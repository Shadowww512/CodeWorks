import pickle
import itertools
from nltk.stem import PorterStemmer
from collections import namedtuple
import math
import sys
import time
# TODO: Refactor code for readability
ps = PorterStemmer()
posting = namedtuple('posting', ['id', 'term_frequency'])
metaData = namedtuple('metaData', ['url', 'tokenCount'])
class search:

    def __init__(self, folderPath: str):
        try:
            print(f'Reading index from {folderPath}')
            # load inverted index
            index_pkl = open(f'index_{folderPath}.pkl', 'rb')
            self.index = pickle.load(index_pkl)
            doc_dict_pkl = open(f'doc_ids_{folderPath}.pkl', 'rb')
            self.doc_dict = pickle.load(doc_dict_pkl)
            with open('terms.txt', 'w') as f:
                f.write(str(self.index.keys()))
        except FileNotFoundError:
            print(f'CAN NOT FIND {folderPath} UNDER THE SAME DIRECTORY')
            sys.exit()
        query = ''
        print('welcome to AntSearch, token spaced will be recognize as AND operation, applied lowercase by default, enter q! to quit')
        # all_terms = list(self.index.keys())
        # sorted(all_terms, key=lambda x: len(self.index[x]),reverse=True)
        # print(f'The top five words in index is {list(itertools.islice(all_terms,5))}')
        while True:
            query = input("Search: ")
            if query == 'q!':
                break
            tokens = query.split(' ')
            tokens = [token.lower() for token in tokens]
            tokens = [token if (token in self.index) else ps.stem(token) for token in tokens]  # stemmed query item if not found in index
            self.searchOn(tokens)
        # close the files
        index_pkl.close()
        doc_dict_pkl.close()

    def searchOn(self, tokens: list[str]) -> None:
        '''perform search on a list of tokens'''
        start = time.process_time()
        try:
            if len(tokens) == 1:
                docs = self.searchSingleToken(tokens[0])
                self.rankOn_tfidf(tokens, docs)
                urls = search.getURLS(docs, self.doc_dict)
            else:
                docs = self.searchANDToken(tokens)
                self.rankOn_tfidf(tokens, docs)
                urls = search.getURLS(docs, self.doc_dict)
            end = time.process_time()
            print('Search took {} MS'.format((end-start)*1000))
            print(f'In total, {len(urls)} results found')
            print(f"Showing top 5 results from query: {tokens}, ranked by tf-idf score")
            if len(urls) == 0:
                print('No results found, try search again for stemmed token')
                self.searchOn(tokens = [ps.stem(token) for token in tokens])
            for url in urls[:5]: # showing the top 5
                print(url)
        except KeyError:
            print('At least one token not found in index')

    def searchSingleToken(self,token:str) -> list:
        '''return document ids corresponding of the token in the index'''
        docs = []
        for p in self.index[token]:
            docs.append(p.id)
        return docs

    @staticmethod
    def findCommon(docs_1:list, docs_2:list) -> [int]:
        '''
        return the common id in the two list
        docs_1 and docs_2 should be list of doc_id sorted in order
        '''
        common = []
        postings_1 = iter(docs_1)
        postings_2 = iter(docs_2)
        # always move the smaller pointer, move both if equal
        try:
            pt1 = -1
            pt2 = -1
            while True:
                if pt1 == pt2:
                    common.append(pt1)
                    pt1 = next(postings_1)
                    pt2 = next(postings_2)
                elif pt1 < pt2:
                    pt1 = next(postings_1)
                else:
                    pt2 = next(postings_2)
        except StopIteration:  # one or more run out, return immediately
            return common[1:]  # skip the first placeholder

    @staticmethod
    def findMultipleCommon(docs: []) -> list:
        '''return the common id among all list of ids'''
        docs.sort(key=lambda p: len(p))  # sort by number of posting in each list
        c = search.findCommon(docs[0], docs[1])
        for posting in docs[2:]: # repeat the comparison for the rest of the list
            c = search.findCommon(c, posting)
        return c

    def searchANDToken(self, tokens: list) -> list:
        '''return ids of all documents that have contains all the tokens'''
        docs = []
        for token in tokens:
            postings = self.index[token]
            token_docs = [p.id for p in postings]
            token_docs.sort() # make sure the id is sorted, consider removing because the id should be in order already
            docs.append(token_docs)
        common_id = search.findMultipleCommon(docs)
        return common_id

    def calculate_tfidf(self, token, doc_id) -> float:
        '''Calculate the tf-idf score on the token and document'''
        # tf = term frequency / total number of word in the document
        # idf = log (total number of document / number of document containing token)
        term_frequency = 0
        for p in self.index[token]:
            if p.id == doc_id:
                term_frequency = p.term_frequency
        tokenCount = self.doc_dict[doc_id].tokenCount
        documentCount = self.index['#docCount#']
        documentWithToken = len(self.index[token])
        tf = term_frequency / tokenCount
        idf = math.log(documentCount/documentWithToken)
        return tf*idf

    def calculateCollected_tfidf(self, tokens: list[str], doc: list[int]) -> float:
        '''Calculate the sum of tfidf score of the doc on each token'''
        return sum([self.calculate_tfidf(token, doc) for token in tokens])

    def rankOn_tfidf(self, tokens: list[str], docs: list[int]) -> None:
        '''Sort the docs based on collected_tfidf score'''
        docs.sort(key=lambda doc: self.calculateCollected_tfidf(tokens, doc), reverse=True)

    @staticmethod
    def getURLS(ids: list, doc_dict) -> list:
        '''return list of urls by acessing the doc_dict from list of doc ids'''
        return [doc_dict[x].url for x in ids]

if __name__ == '__main__':
    folderPath = sys.argv[1]
    newSearch = search(folderPath)

