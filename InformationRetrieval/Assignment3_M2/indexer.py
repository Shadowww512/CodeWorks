import os
from pathlib import Path
import json
import re
from bs4 import BeautifulSoup
from nltk.stem import PorterStemmer
import pickle
import time
from collections import namedtuple
import sys
invertedIndex = {}
doc_id = 0
doc_dict = {}
token_pattern = re.compile(r'[a-zA-Z0-9]+', re.IGNORECASE)
posting = namedtuple('posting', ['id', 'term_frequency'])
metaData = namedtuple('metaData', ['url', 'tokenCount'])

# TODO: Need to make posting a namedtuple for readability
# TODO: Refactor the code, while preserving its speed
# TODO: Deal with stemming error
def main(folderPath:str):
  global doc_id
  start_time = time.process_time()
  all_files_path = Path(folderPath).rglob('*')
  for path in all_files_path:
    if not path.is_file(): continue
    if '.DS_Store' in str(path): continue
    file = open(path)
    json_obj = json.load(file)
    if is_HTML(json_obj):
      doc_id += 1
      print(doc_id)
      updateIndex(doc_id, json_obj)
    file.close()
  invertedIndex['#docCount#'] = doc_id  # this reserve key is used to store metaData of the index
  storeIndex()
  with open(f'doc_ids_{folderPath}.pkl', 'wb') as f:
    pickle.dump(doc_dict, f)
  end_time = time.process_time()
  elapsed_seconds = end_time - start_time
  elapsed_minutes = elapsed_seconds // 60
  print(f'The whole process takes {elapsed_seconds} seconds, ~ {elapsed_minutes} minutes')
  print(f'There is {len(invertedIndex)} unique tokens after stemming')
  print(f'In total, {doc_id} files has been indexed')
  # print(list(itertools.islice(invertedIndex.items(),3)))
def is_HTML(json_obj):
  url = json_obj['url']
  content = json_obj['content']
  return (re.match(r".*\.(html|shtml|htm)$", url)
                or
          'html' in content[:30].lower())

def get_tokens(text:str):
  pattern = token_pattern
  yield from re.findall(pattern, text)

def get_stemmed_tokens(tokens):
  ps = PorterStemmer()
  for token in tokens:
    yield ps.stem(token)

def get_freq_dict(tokens):
  d = {}
  for token in tokens:
    if token in d:
      d[token] += 1
    else:
      d[token] = 1
  return d

def updateIndex(doc_id, jsonData):
  soup = BeautifulSoup(jsonData['content'],'html.parser')
  text = soup.get_text()
  tokens = list(get_tokens(text))
  doc_dict[doc_id] = metaData(url=jsonData['url'], tokenCount=len(tokens))
  freq_dict = get_freq_dict(get_stemmed_tokens(tokens))
  for token in freq_dict:
    p = posting(doc_id, freq_dict[token])
    if token in invertedIndex:
      invertedIndex[token].append(p)
    else:
      invertedIndex[token] = [p]

def storeIndex():
  with open(f'index_{folderPath}.pkl', 'wb') as f:
    pickle.dump(invertedIndex, f)

if __name__ == '__main__':
  folderPath = sys.argv[1]
  main(folderPath)