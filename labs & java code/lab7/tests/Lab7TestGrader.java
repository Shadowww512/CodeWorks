package labs.lab7.tests;

import labs.lab7.*;
import java.io.*;
import org.junit.FixMethodOrder;
import org.junit.Test;
import java.util.*;

import static org.junit.Assert.*;

@FixMethodOrder()
public class Lab7TestGrader {

    // 0.1pt
    @Test
    public void problem1_NegativeTest1() {
        String inp_str = "*"; 
        String result = Main.problem1_addStars(inp_str);
        assertEquals(inp_str,result);
        assertNotNull(result);
    }
    
    // 0.1pt
    @Test
    public void problem1_NegativeTest2() {
        String inp_str = ""; 
        String result = Main.problem1_addStars(inp_str);
        assertEquals(inp_str,result);
        assertNotNull(result);
    }    
    
    // 0.1pt
    @Test
    public void problem1_TwoTest1() {
        String inp_str = "**"; 
        String result = Main.problem1_addStars(inp_str);
        assertEquals("***",result);
        assertNotNull(result);
    }    
    
    // 0.1pt
    @Test
    public void problem1_TwoTest2() {
        String inp_str = "Za"; 
        String result = Main.problem1_addStars(inp_str);
        assertEquals("Z*a",result);
        assertNotNull(result);
    }    
    
    // 0.1pt
    @Test
    public void problem1_MediumTest1() {
        String inp_str = "daMeiN"; 
        String result = Main.problem1_addStars(inp_str);
        assertEquals("d*a*M*e*i*N",result);
        assertNotNull(result);
    }     
    
    // 0.1pt
    @Test
    public void problem1_MediumTest2() {
        String inp_str = "RoberT"; 
        String result = Main.problem1_addStars(inp_str);
        assertEquals("R*o*b*e*r*T",result);
        assertNotNull(result);
    }     
    
    // 0.1pt
    @Test
    public void problem1_MediumTest3() {
        String inp_str = "HAWKINS"; 
        String result = Main.problem1_addStars(inp_str);
        assertEquals("H*A*W*K*I*N*S",result);
        assertNotNull(result);
    }     
    
    // 0.1pt
    @Test
    public void problem1_BigTest1() {
        String inp_str = "honorificabilitudinitatibus"; 
        String result = Main.problem1_addStars(inp_str);
        assertEquals("h*o*n*o*r*i*f*i*c*a*b*i*l*i*t*u*d*i*n*i*t*a*t*i*b*u*s",result);
        assertNotNull(result);
    }     
    
    // 0.1pt
    @Test
    public void problem1_BigTest2() {
        String inp_str = "antidisestablishmentarianism"; 
        String result = Main.problem1_addStars(inp_str);
        assertEquals("a*n*t*i*d*i*s*e*s*t*a*b*l*i*s*h*m*e*n*t*a*r*i*a*n*i*s*m",result);
        assertNotNull(result);
    } 
    
    // 0.1pt
    @Test
    public void problem1_BigTest3() {
        String inp_str = "supercalifragilisticexpialidocious"; 
        String result = Main.problem1_addStars(inp_str);
        assertEquals("s*u*p*e*r*c*a*l*i*f*r*a*g*i*l*i*s*t*i*c*e*x*p*i*a*l*i*d*o*c*i*o*u*s",result);
        assertNotNull(result);
    } 
    
    //0.1pt
    @Test
    public void problem2_NegativeTest1() {
        int[] inp_nums = new int[] {7, 1, 5, 9}; 
        boolean result = Main.problem2_contains6(inp_nums, 0);
        assertFalse(result);
    }         
    
    //0.1pt
    @Test
    public void problem2_NegativeTest2() {
    	  int[] inp_nums = new int[] {17, 101, 35, 8}; 
          boolean result = Main.problem2_contains6(inp_nums, 0);
          assertFalse(result);
    }         
    
    //0.1pt
    @Test
    public void problem2_NegativeTest3() {
    	  int[] inp_nums = new int[] {99, 1079, 678, 0, 53, 87, 23, 56}; 
          boolean result = Main.problem2_contains6(inp_nums, 0);
          assertFalse(result);
    }         
    
    // 0.1pt
    @Test
    public void problem2_MediumTest1() {
    	int[] inp_nums = new int[] {100, 12, 6, 1, 1, 12, 100, 1, 12, 100, 1, 1}; 
        boolean result = Main.problem2_contains6(inp_nums, 0);
        assertEquals(true,result);
    }     
    
    // 0.1pt
    @Test
    public void problem2_MediumTest2() {
    	int[] inp_nums = new int[] {10, 5, 4, 3, 48, 6, 2, 33, 53, 10}; 
        boolean result = Main.problem2_contains6(inp_nums, 0);       
        assertEquals(true, result);
    }     
    
    // 0.1pt
    @Test
    public void problem2_MediumTest3() {
    	int[] inp_nums = new int[] { 1, 5, 7, 10, 12, 14, 15, 18, 20, 22, 25, 27, 30, 6, 4, 110, 220}; 
        boolean result = Main.problem2_contains6(inp_nums, 0);   
        assertEquals(true, result);
    } 
    
    // 0.1pt
    @Test
    public void problem2_BigTest1() {
    	  int[] inp_nums = new int[] {54,326,78,9013,89,2014,531,90,3492,543,26,789,1038,92,1045,31,90,349,2543,26,789,40138,9,201,6}; 
          boolean result = Main.problem2_contains6(inp_nums, 0);
          assertTrue(result);
    }      
    
    // 0.1pt
    @Test
    public void problem2_BigTest2() {
    	  int[] inp_nums = new int[] {789,7013,89,2014,53,190,3492,5432,678,90,7890,138,920,14,53,1903,49,254,326,7890,190,349,254,326,78,90}; 
          boolean result = Main.problem2_contains6(inp_nums, 0);
          assertFalse(result);
    }      
    
    // 0.1pt
    @Test
    public void problem2_BigTest3() {
    	  int[] inp_nums = new int[] {100, 12, 100, 6, 1, 12, 100, 1, 12, 100, 1, 1, 6 }; 
          boolean result = Main.problem2_contains6(inp_nums, 0);
          assertTrue(result);
    }
    
    // 0.1pt
    @Test
    public void problem2_BigTest4() {
    	  int[] inp_nums = new int[] { 6, 6 }; 
          boolean result = Main.problem2_contains6(inp_nums, 0);
          assertTrue(result);
    }
    
    //1pt
    @Test
    public void problem3_NegativeTest1() {
    	String inp_str = "apqrxyzzzzzz";
    	boolean result = Main.problem3_nested(inp_str);
        assertFalse(result);
    }         
    
    //1pt
    @Test
    public void problem3_NegativeTest2() {
    	String inp_str = "( )";
    	boolean result = Main.problem3_nested(inp_str);
        assertFalse(result);
    }         

    //1pt
    @Test
    public void problem3_TrivialTest1() {
    	String inp_str = "(())"; 
    	boolean result = Main.problem3_nested(inp_str);
        assertTrue(result);
    }         
    
    //1pt
    @Test
    public void problem3_TrivialTest2() {
    	String inp_str = "((()))";
    	boolean result = Main.problem3_nested(inp_str);
        assertTrue(result);
    }
    
    // 1pt
    @Test
    public void problem3_MediumTest1() {
    	String inp_str = "aa(((((((((((())))))))))))zz";
    	boolean result = Main.problem3_nested(inp_str);
        assertFalse(result);
    }     
    
    // 1pt
    @Test
    public void problem3_MediumTest2() {
    	String inp_str = "(abcd((((((((((()))))))))))dcba)";
    	boolean result = Main.problem3_nested(inp_str);
        assertFalse(result);
    }     
    
    // 1pt
    @Test
    public void problem3_MediumTest3() {
    	String inp_str = "(((((((((((())))))))))))";
    	boolean result = Main.problem3_nested(inp_str);
        assertTrue(result);
    } 
    
    // 1pt
    @Test
    public void problem3_BigTest1() {
    	String inp_str = "(((((((((((((((((((((((())))))))))))))))))))))))";
    	boolean result = Main.problem3_nested(inp_str);
        assertTrue(result);
    }      
    
    // 1pt
    @Test
    public void problem3_BigTest2() {
    	String inp_str = "()()()()()()((()(()())))(()()((()())(((()))))())(()()()()()((())()(())())";
    	boolean result = Main.problem3_nested(inp_str);
        assertFalse(result);
    }      
    
    // 1pt
    @Test
    public void problem3_BigTest3() {
    	String inp_str = "(((((((((((((((((((((((((((((((((((((((((((((((((((((((((((())))))))))))))))))))))))))))))))))))))))))))))))))))))))))))";
    	boolean result = Main.problem3_nested(inp_str);
        assertTrue(result);
    }      

    //1pt
    @Test
    public void problem4_NegativeTest1() {
		Country country_1 = new Country("",-1);
		assertEquals("", country_1.getName()); 
		assertEquals(-1, country_1.getPopulation()); 
    }         
    
    //1pt
    @Test
    public void problem4_NegativeTest2() {
		Country country_1 = new Country("(  )",-101);
		assertEquals("(  )", country_1.getName()); 
		assertEquals(-101, country_1.getPopulation());
    }         

    //1pt
    @Test
    public void problem4_TrivialTest1() {
		Country country_1 = new Country("USA",335641000);
		assertEquals("USA", country_1.getName()); 
		assertEquals(335641000, country_1.getPopulation());
		
		Country country_2 = new Country("UK",67026292);
		assertEquals("UK", country_2.getName()); 
		assertEquals(67026292, country_2.getPopulation());	
		
		assertTrue(country_1.compareTo(country_2) > 0); 
    }         
    
    //1pt
    @Test
    public void problem4_TrivialTest2() {

		Country country_1 = new Country("USA",335641000);
		assertEquals("USA", country_1.getName()); 
		assertEquals(335641000, country_1.getPopulation());
		
		Country country_2 = new Country("Mexico",129202482);
		assertEquals("Mexico", country_2.getName()); 
		assertEquals(129202482, country_2.getPopulation());	
	
		Country country_3 = new Country("Canada",40097761);
		assertEquals("Canada", country_3.getName()); 
		assertEquals(40097761, country_3.getPopulation());			
		
		assertTrue(country_1.compareTo(country_2) > 0); 
		assertTrue(country_2.compareTo(country_3) > 0); 
		assertTrue(country_3.compareTo(country_1) < 0); 

    }      
    
    // 1pt
    @Test
    public void problem4_MediumTest1() {

		Country country_1 = new Country("lilliputs",11);
		Country country_2 = new Country("humans",111111);
		Country country_3 = new Country("horses",111);
		Country country_4 = new Country("rabbits",111);
		Country country_5 = new Country("dinos",0);
		
		assertTrue(country_1.compareTo(country_2) < 0); 
		assertTrue(country_2.compareTo(country_3) > 0); 
		assertTrue(country_3.compareTo(country_4) == 0); 
		assertTrue(country_4.compareTo(country_5) > 0); 
		assertTrue(country_5.compareTo(country_1) < 0); 
    }     
    
    // 1pt
    @Test
    public void problem4_MediumTest2() {

		Country country_1 = new Country("lilliputs",11);
		Country country_2 = new Country("humans",111111);
		Country country_3 = new Country("horses",111);
		Country country_4 = new Country("rabbits",111);
		Country country_5 = new Country("dinos",0);
		
		assertTrue(country_3.compareTo(country_1) > 0); 
		assertTrue(country_3.compareTo(country_2) < 0); 
		assertTrue(country_3.compareTo(country_4) == 0); 
		assertTrue(country_3.compareTo(country_5) > 0); 
		
		assertEquals("horses", country_3.getName()); 
		assertEquals(111, country_3.getPopulation());
    	
    }     
    
    // 1pt
    @Test
    public void problem4_MediumTest3() {

		Country country_1 = new Country("lilliputs",11);
		Country country_2 = new Country("humans",111111);
		Country country_3 = new Country("horses",111);
		Country country_4 = new Country("rabbits",111);
		Country country_5 = new Country("dinos",0);    	
    	
		assertTrue(country_1.compareTo(country_2) < 0); 
		assertTrue(country_1.compareTo(country_3) < 0); 
		assertTrue(country_1.compareTo(country_4) < 0); 
		assertTrue(country_1.compareTo(country_5) > 0); 		
		
		assertTrue(country_2.compareTo(country_1) > 0); 
		assertTrue(country_2.compareTo(country_3) > 0); 
		assertTrue(country_2.compareTo(country_4) > 0); 
		assertTrue(country_2.compareTo(country_5) > 0); 			
		
		assertTrue(country_4.compareTo(country_1) > 0); 
		assertTrue(country_4.compareTo(country_2) < 0); 
		assertTrue(country_4.compareTo(country_3) == 0); 
		assertTrue(country_4.compareTo(country_5) > 0); 
		
		assertTrue(country_5.compareTo(country_1) < 0); 
		assertTrue(country_5.compareTo(country_2) < 0); 
		assertTrue(country_5.compareTo(country_3) < 0); 
		assertTrue(country_5.compareTo(country_4) < 0); 
		assertTrue(country_5.compareTo(country_5) == 0); 
		
    } 
    
    // 1pt
    @Test
    public void problem4_BigTest1() {
		Country country_1 = new Country("lilliputs",11);
		Country country_2 = new Country("humans",111111);
		Country country_3 = new Country("horses",111);
		Country country_4 = new Country("rabbits",111);
		Country country_5 = new Country("dinos",0);  
		Country country_6 = new Country("USA",335641000);
		Country country_7 = new Country("Mexico",129202482);
		Country country_8 = new Country("Canada",40097761);
		Country country_9 = new Country("Brazil",203062512);
		Country country_10 = new Country("Ukraine",41130432);  		
		
		assertTrue(country_6.compareTo(country_1) > 0); 
		assertTrue(country_6.compareTo(country_2) > 0); 
		assertTrue(country_6.compareTo(country_3) > 0); 
		assertTrue(country_6.compareTo(country_4) > 0); 
		assertTrue(country_6.compareTo(country_5) > 0); 
		assertTrue(country_6.compareTo(country_6) == 0); 
		assertTrue(country_6.compareTo(country_7) > 0); 
		assertTrue(country_6.compareTo(country_8) > 0); 
		assertTrue(country_6.compareTo(country_9) > 0); 
		assertTrue(country_6.compareTo(country_10) > 0); 

    }      
    
    // 1pt
    @Test
    public void problem4_BigTest2() {
		Country country_1 = new Country("India",1392329000);
		Country country_2 = new Country("South Africa",62027503);
		Country country_3 = new Country("France",68184000);
		Country country_4 = new Country("Germany",84482267);
		Country country_5 = new Country("China",1411750000);  
		Country country_6 = new Country("USA",335641000);
		Country country_7 = new Country("Mexico",129202482);
		Country country_8 = new Country("Canada",40097761);
		Country country_9 = new Country("Brazil",203062512);
		Country country_10 = new Country("Ukraine",41130432);  

		assertTrue(country_1.compareTo(country_2) > 0); 
		assertTrue(country_2.compareTo(country_3) < 0); 
		assertTrue(country_3.compareTo(country_4) < 0); 
		assertTrue(country_4.compareTo(country_5) < 0); 
		assertTrue(country_5.compareTo(country_6) > 0); 
		assertTrue(country_6.compareTo(country_7) > 0); 				
		assertTrue(country_7.compareTo(country_8) > 0); 
		assertTrue(country_8.compareTo(country_9) < 0); 
		assertTrue(country_9.compareTo(country_10) > 0); 		
		
    }      
    
    // 1pt
    @Test
    public void problem4_BigTest3() {
		Country country_1 = new Country("India",1392329000);
		Country country_2 = new Country("South Africa",62027503);
		Country country_3 = new Country("France",68184000);
		Country country_4 = new Country("Germany",84482267);
		Country country_5 = new Country("China",1411750000);  
		Country country_6 = new Country("USA",335641000);
		Country country_7 = new Country("Mexico",129202482);
		Country country_8 = new Country("Canada",40097761);
		Country country_9 = new Country("Brazil",203062512);
		Country country_10 = new Country("Ukraine",41130432);  
		
		assertEquals("South Africa", country_2.getName()); 
		assertEquals(62027503, country_2.getPopulation());
		
		assertEquals("Germany", country_4.getName()); 
		assertEquals(84482267, country_4.getPopulation());		
		
		assertEquals("USA", country_6.getName()); 
		assertEquals(335641000, country_6.getPopulation());
		
		assertEquals("Canada", country_8.getName()); 
		assertEquals(40097761, country_8.getPopulation());
		
		assertEquals("Ukraine", country_10.getName()); 
		assertEquals(41130432, country_10.getPopulation());

		assertTrue(country_1.compareTo(country_3) > 0); 
		assertTrue(country_3.compareTo(country_5) < 0); 
		assertTrue(country_5.compareTo(country_7) > 0); 
		assertTrue(country_7.compareTo(country_9) < 0); 
		assertTrue(country_2.compareTo(country_4) < 0); 
		assertTrue(country_4.compareTo(country_6) < 0); 				
		assertTrue(country_6.compareTo(country_8) > 0); 
		assertTrue(country_8.compareTo(country_10) < 0); 
		
		assertTrue(country_1.compareTo(country_1) == 0); 
		assertTrue(country_2.compareTo(country_2) == 0); 
		assertTrue(country_3.compareTo(country_3) == 0); 
		assertTrue(country_4.compareTo(country_4) == 0); 
		assertTrue(country_5.compareTo(country_5) == 0); 
		assertTrue(country_6.compareTo(country_6) == 0); 				
		assertTrue(country_7.compareTo(country_7) == 0); 
		assertTrue(country_8.compareTo(country_8) == 0); 
		assertTrue(country_9.compareTo(country_9) == 0); 	
		assertTrue(country_10.compareTo(country_10) == 0);		
    }      
    
    //1pt
    @Test
    public void problem5_NegativeTest1() {
    	TravelRecord record = new TravelRecord();
    	assertEquals("", record.getNamesOrderedByPopulation());
    	assertFalse(record.removeCountry(11));	
    	assertFalse(record.removeCountry("USA"));	
    	assertNull(record.findCountryByPopulation(987));
    	assertNull(record.findCountryByName("USA"));
    }         
    
    //1pt
    @Test
    public void problem5_NegativeTest2() {
    	TravelRecord record = new TravelRecord();
    	
    	record.addCountry("USA", 335641000);
    	record.removeCountry(335641000);
    	
    	assertEquals("", record.getNamesOrderedByPopulation());
    	assertFalse(record.removeCountry(11));	
    	assertFalse(record.removeCountry("USA"));	
    	assertNull(record.findCountryByPopulation(987));
    	assertNull(record.findCountryByName("USA"));
    }         

    //1pt
    @Test
    public void problem5_TrivialTest1() {
    	
    	TravelRecord record = new TravelRecord();
    	
    	record.addCountry("USA", 335641000);
    	record.addCountry("Canada", 40097761);
    	record.addCountry("Mexico", 129202482);


    	assertEquals("Canada Mexico USA", record.getNamesOrderedByPopulation());
    	assertNotNull(record.findCountryByPopulation(129202482));
    	assertNotNull(record.findCountryByName("USA"));
    	assertTrue(record.removeCountry("USA"));
    	assertTrue(record.removeCountry(129202482));
    }         
    
    //1pt
    @Test
    public void problem5_TrivialTest2() {

    	TravelRecord record = new TravelRecord();
    	
    	record.addCountry("USA", 335641000);
    	record.addCountry("Canada", 40097761);
    	record.addCountry("Mexico", 129202482);

    	
    	assertNotNull(record.findCountryByPopulation(129202482));
    	assertNotNull(record.findCountryByName("USA"));
    	assertTrue(record.removeCountry("USA"));
    	assertTrue(record.removeCountry(129202482));
    	assertEquals("Canada", record.getNamesOrderedByPopulation());
    }      
    
    // 1pt
    @Test
    public void problem5_MediumTest1() {
    	TravelRecord record = new TravelRecord();
    	record.addCountry("lilliputs",11);
    	record.addCountry("humans",111111);
    	record.addCountry("ants",111);
    	record.addCountry("horses",112);
    	record.addCountry("rabbits",113);
    	record.addCountry("dinos",0);
    	
    	String output = record.getNamesOrderedByPopulation();
    	assertEquals("dinos lilliputs ants horses rabbits humans", output);
    	
    	assertNotNull(record.findCountryByPopulation(111));
    	assertNull(record.findCountryByName("lillies"));
    	
    	assertTrue(record.removeCountry("dinos"));
    	assertTrue(record.removeCountry(111));    	
    	
    	output = record.getNamesOrderedByPopulation();
    	assertEquals("lilliputs horses rabbits humans", output);
    }     
    
    // 1pt
    @Test
    public void problem5_MediumTest2() {
    	TravelRecord record = new TravelRecord();
    	record.addCountry("Lilliputs",1111);
    	record.addCountry("Humans",111111);
    	record.addCountry("Horses",111);
    	record.addCountry("Dinos",1);
    	
    	assertFalse(record.removeCountry("dinos"));
    	assertTrue(record.removeCountry("Lilliputs"));
    	assertTrue(record.removeCountry(111));
    	
    	String output = record.getNamesOrderedByPopulation();
    	assertEquals("Dinos Humans", output);
    }     
    
    // 1pt
    @Test
    public void problem5_MediumTest3() {

    	TravelRecord record = new TravelRecord();
    	record.addCountry("Lilliputs",1111);
    	record.addCountry("Humans",111111);
    	record.addCountry("Horses",111);
    	record.removeCountry(111);
    	record.addCountry("Ants", 111);
    	record.addCountry("Dinos",1);
    	    	
    	Country output = record.findCountryByPopulation(1);
    	assertEquals("Dinos", output.getName());    	

    	output = record.findCountryByPopulation(111);
    	assertEquals("Ants", output.getName());     	
    	
    } 
    
    // 1pt
    @Test
    public void problem5_BigTest1() {
    	TravelRecord record = new TravelRecord();
    	record.addCountry("India",1392329000);
		record.addCountry("South Africa",62027503);
		record.addCountry("France",68184000);
		record.addCountry("Germany",84482267);
		record.addCountry("China",1411750000);
		record.addCountry("USA",335641000);
		record.addCountry("Mexico",129202482);
		record.addCountry("Canada",40097761);
		record.addCountry("Brazil",203062512);
		record.addCountry("Ukraine",41130432);
		
		// remove last two countries
		assertTrue(record.removeCountry(203062512));
    	assertTrue(record.removeCountry(41130432));
    	assertFalse(record.removeCountry(111));
		
		assertNull(record.findCountryByName("Ukraine"));
    	assertNull(record.findCountryByName("Brazil"));
    	assertNotNull(record.findCountryByName("France"));
    	
    	assertNull(record.findCountryByPopulation(203062512));
    	assertNotNull(record.findCountryByPopulation(129202482));
    	
    	assertEquals("Canada South Africa France Germany Mexico USA India China", record.getNamesOrderedByPopulation());
    	
    }      
    
    // 1pt
    @Test
    public void problem5_BigTest2() {
    	TravelRecord record = new TravelRecord();
    	record.addCountry("India",1392329000);
		record.addCountry("South Africa",62027503);
		record.addCountry("France",68184000);
		record.addCountry("Germany",84482267);
		record.addCountry("China",1411750000);
		record.addCountry("USA",335641000);
		record.addCountry("Mexico",129202482);
		record.addCountry("Canada",40097761);
		record.addCountry("Brazil",203062512);
		record.addCountry("Ukraine",41130432);
		
		assertTrue(record.removeCountry(1392329000));
		record.addCountry("Italy",58780965);
		assertTrue(record.removeCountry("Germany"));
		
		String output = record.getNamesOrderedByPopulation();
		assertEquals("Canada Ukraine Italy South Africa France Mexico Brazil USA China",output);
    }      
    
    // 1pt
    @Test
    public void problem5_BigTest3() {
    	TravelRecord record1 = new TravelRecord();
    	record1.addCountry("India",1392329000);
		record1.addCountry("South Africa",62027503);
		record1.addCountry("France",68184000);
		assertEquals(record1.findCountryByPopulation(68184000).getPopulation(), record1.findCountryByName("France").getPopulation());		
		
		TravelRecord record2 = new TravelRecord();
		record2.addCountry("Germany",84482267);
		record2.addCountry("China",1411750000);
		record2.addCountry("USA",335641000);
		
		TravelRecord record3 = new TravelRecord();
		record3.addCountry("Mexico",129202482);
		record3.addCountry("Canada",40097761);
		record3.addCountry("China",1411750000);
		record3.addCountry("Ukraine",41130432);
		assertEquals(record2.findCountryByPopulation(1411750000).getPopulation(), record3.findCountryByName("China").getPopulation());						
		record3.removeCountry("China");
		record3.addCountry("Brazil",203062512);
		
		TravelRecord record4 = new TravelRecord();
		record4.addCountry("Mexico",129);
		record4.addCountry("Canada",40);
		record4.addCountry("Brazil",203);
		record4.addCountry("Ukraine",41);
		assertEquals(record3.getNamesOrderedByPopulation(), record4.getNamesOrderedByPopulation());
		assertEquals(record3.findCountryByPopulation(129202482).getName(), record4.findCountryByPopulation(129).getName());
    }
        
    //1pt
    @Test
    public void problem6_NegativeTest1() {
	
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));

     	String nonExistentFileName = "empty.html";
		new HTMLFile(nonExistentFileName);

		String result = output.toString();
		assertEquals("File: " + nonExistentFileName + " not found", result);
    }         
    
    //1pt
    @Test
    public void problem6_NegativeTest2() {
    	HTMLFile file = new HTMLFile("res/NegTagSample.html");
		assertFalse(file.isValid());
    }         

    //1pt
    @Test
    public void problem6_TrivialTest1() {
    	HTMLFile file = new HTMLFile("res/TrivialTest1.html");
		assertTrue(file.isValid());
    }         
    
    //1pt
    @Test
    public void problem6_TrivialTest2() {
    	HTMLFile file = new HTMLFile("res/TrivialTest2.html");
		assertTrue(file.isValid());
    }      
    
    // 1pt
    @Test
    public void problem6_MediumTest1() {
    	HTMLFile file = new HTMLFile("res/MediumTest1.html");
		assertFalse(file.isValid());
    }     
    
    // 1pt
    @Test
    public void problem6_MediumTest2() {
    	HTMLFile file = new HTMLFile("res/MediumTest2.html");
		assertTrue(file.isValid());
    }     
    
    // 1pt
    @Test
    public void problem6_MediumTest3() {
    	HTMLFile file = new HTMLFile("res/MediumTest3.html");
		assertFalse(file.isValid());
    } 
    
    // 1pt
    @Test
    public void problem6_BigTest1() {
    	HTMLFile file = new HTMLFile("res/BigTest1.html");
		assertTrue(file.isValid());
    }      
    
    // 1pt
    @Test
    public void problem6_BigTest2() {
    	HTMLFile file = new HTMLFile("res/BigTest2.html");
		assertTrue(file.isValid());
    }      
    
    // 1pt
    @Test
    public void problem6_BigTest3() {
    	HTMLFile file = new HTMLFile("res/BigTest3.html");
		assertTrue(file.isValid());
    }      
    
    //1pt
    @Test
    public void problem7_NegativeTest1() {
        ToDoList todo = new ToDoList();
        assertNull(todo.nextTask());
    }         
    
    //1pt
    @Test
    public void problem7_NegativeTest2() {
        ToDoList todo = new ToDoList();
        todo.addTask(10, "");
        assertEquals("",todo.nextTask().getDescription());
    }         

    //1pt
    @Test
    public void problem7_TrivialTest1() {
        ToDoList todo = new ToDoList();
        todo.addTask(1, "read book");
        todo.addTask(2, "wash dishes");
        
        assertEquals("read book", todo.nextTask().getDescription());
        todo.addTask(1, "walk dog");
        assertEquals("walk dog", todo.nextTask().getDescription());
        assertEquals("wash dishes", todo.nextTask().getDescription());
    }         
    
    //1pt
    @Test
    public void problem7_TrivialTest2() {
    	ToDoList todo = new ToDoList();
    	
        todo.addTask(5, "read book");
        todo.addTask(8, "wash dishes");
        todo.addTask(1, "eat lunch");
        assertEquals("eat lunch", todo.nextTask().getDescription());
        todo.addTask(2, "walk dog");
        assertEquals("walk dog", todo.nextTask().getDescription());
        assertEquals("read book", todo.nextTask().getDescription());
        assertEquals("wash dishes", todo.nextTask().getDescription());    	
 	
    }      
    
    // 1pt
    @Test
    public void problem7_MediumTest1() {
    	ToDoList todo = new ToDoList();
    	
        todo.addTask(1, "Geoffrey Hinton");
        todo.addTask(2, "Yejin Choi");
        todo.addTask(3, "Fei Fei le");
        assertEquals("Geoffrey Hinton", todo.nextTask().getDescription());
        todo.addTask(1, "Sameer Singh");
        assertEquals("Sameer Singh", todo.nextTask().getDescription());
        assertEquals(2, todo.nextTask().getPriority());
        assertEquals("Fei Fei le", todo.nextTask().getDescription()); 
    }     
    
    // 1pt
    @Test
    public void problem7_MediumTest2() {
    	ToDoList todo = new ToDoList();
    	
        todo.addTask(1, "Geoffrey Hinton");
        todo.addTask(1, "Yejin Choi");
        todo.addTask(2, "Fei Fei le");
        todo.addTask(2, "Sameer Singh");
        
        // priority 1 tasks:
        Task next = todo.nextTask();
        String expectedDescription1 = "Geoffrey Hinton";
        int expectedPriority1 = 1;
        String expectedDescription2 = "Yejin Choi";
        int expectedPriority2 = 1;
        assertTrue((expectedDescription1.equals(next.getDescription()) && expectedPriority1 == next.getPriority()) ||
        		(expectedDescription2.equals(next.getDescription()) && expectedPriority2 == next.getPriority()));
        next = todo.nextTask();
        assertTrue((expectedDescription1.equals(next.getDescription()) && expectedPriority1 == next.getPriority()) ||
        		(expectedDescription2.equals(next.getDescription()) && expectedPriority2 == next.getPriority()));
        
        // priority 2 tasks:
        next = todo.nextTask();
        expectedDescription1 = "Fei Fei le";
        expectedPriority1 = 2;
        expectedDescription2 = "Sameer Singh";
        expectedPriority2 = 2;
        assertTrue((expectedDescription1.equals(next.getDescription()) && expectedPriority1 == next.getPriority()) ||
        		(expectedDescription2.equals(next.getDescription()) && expectedPriority2 == next.getPriority()));
        next = todo.nextTask();
        assertTrue((expectedDescription1.equals(next.getDescription()) && expectedPriority1 == next.getPriority()) ||
        		(expectedDescription2.equals(next.getDescription()) && expectedPriority2 == next.getPriority()));
    }     
    
    // 1pt
    @Test
    public void problem7_MediumTest3() {
    	ToDoList todo = new ToDoList();
    	
        todo.addTask(3, "Geoffrey Hinton");
        todo.addTask(4, "Yejin Choi");
        todo.addTask(2, "Fei Fei le");
        todo.addTask(6, "Sameer Singh");
        assertEquals("Fei Fei le", todo.nextTask().getDescription());
        assertEquals("Geoffrey Hinton", todo.nextTask().getDescription());
        assertEquals("Yejin Choi", todo.nextTask().getDescription());
        assertEquals(6, todo.nextTask().getPriority());
    } 
    
    // 1pt
    @Test
    public void problem7_BigTest1() {
    	
    	ToDoList todo = new ToDoList();
    	
    	todo.addTask(1, "");
    	todo.addTask(9087, "Geoffrey Hinton");
    	todo.addTask(2, "Ilay Sutskever");
        todo.addTask(4, "Yejin Choi");
        todo.addTask(10, "Shreya Rajgopal");
        assertEquals("", todo.nextTask().getDescription());
        assertEquals(2, todo.nextTask().getPriority());
        assertEquals("Yejin Choi", todo.nextTask().getDescription());
        
        todo.addTask(1, "Fei Fei le");
        todo.addTask(2, "Parag Singhal");

        assertEquals("Fei Fei le", todo.nextTask().getDescription());
        assertEquals("Parag Singhal", todo.nextTask().getDescription());
        assertEquals(10, todo.nextTask().getPriority());
        assertEquals("Geoffrey Hinton", todo.nextTask().getDescription());

    }      
    
    // 1pt
    @Test
    public void problem7_BigTest2() {
    	ToDoList todo = new ToDoList();
    	
    	todo.addTask(2, "-");
    	todo.addTask(4, "*");
    	todo.addTask(6, "/");
        todo.addTask(8, "+");

        assertEquals("-", todo.nextTask().getDescription());
        assertEquals(4, todo.nextTask().getPriority());
        todo.nextTask();
        todo.nextTask();
        
    	todo.addTask(89, "!");
    	todo.addTask(67, "@");
    	todo.addTask(90, "#");
        todo.addTask(-2, "$");

        assertEquals("$", todo.nextTask().getDescription());
        assertEquals(67, todo.nextTask().getPriority());
        assertEquals(89, todo.nextTask().getPriority());
        assertEquals("#", todo.nextTask().getDescription());

    }      
    
    // 1pt
    @Test
    public void problem7_BigTest3() {
    	ToDoList todo = new ToDoList();
    	
    	todo.addTask(1, "-");
    	todo.addTask(2, "*");
    	todo.addTask(3, "/");
        todo.addTask(4, "+");

        assertEquals("-", todo.nextTask().getDescription());
        assertEquals(2, todo.nextTask().getPriority());
        todo.nextTask();
        todo.nextTask();
        
    	todo.addTask(9, "#");
    	todo.addTask(7, "##");
    	todo.addTask(8, "###");
        todo.addTask(6, "####");

        assertEquals("####", todo.nextTask().getDescription());
        assertEquals(7, todo.nextTask().getPriority());
        assertEquals(8, todo.nextTask().getPriority());
        assertEquals("#", todo.nextTask().getDescription());
    }         
    
    //1pt
    @Test
    public void problem8_NegativeTest1() {
        ToDoList todo = new ToDoList();
        todo.addTask(100, "");
        todo.addTask(101, "**");
        assertEquals("",todo.nextTask().getDescription());
        assertEquals(101,todo.nextTask().getPriority());
    }         
    
    //1pt
    @Test
    public void problem8_NegativeTest2() {
        ToDoList todo = new ToDoList();
        todo.addTask(-1, "");
        assertEquals(-1,todo.nextTask().getPriority());
    }         

    //1pt
    @Test
    public void problem8_TrivialTest1() {

    	ToDoList todo = new ToDoList();
    	
        todo.addTask(7, "Jitendra Malik");
        todo.addTask(8, "Chris Manning");
        todo.addTask(9, "Bruce Wayne");
        assertEquals("Jitendra Malik", todo.nextTask().getDescription());
        todo.addTask(10, "Peter Abbeel");
        assertEquals("Chris Manning", todo.nextTask().getDescription());
        assertEquals(9, todo.nextTask().getPriority());
        assertEquals("Peter Abbeel", todo.nextTask().getDescription());     	
    	
    }         
    
    //1pt
    @Test
    public void problem8_TrivialTest2() {

    	ToDoList todo = new ToDoList();
    	
        todo.addTask(-6, "Jitendra Malik");
        todo.addTask(0, "Chris Manning");
        todo.addTask(90, "Bruce Wayne");
        assertEquals("Jitendra Malik", todo.nextTask().getDescription());
        assertEquals("Chris Manning", todo.nextTask().getDescription());
        assertEquals(90, todo.nextTask().getPriority());
    	
    }      
    
    // 1pt
    @Test
    public void problem8_MediumTest1() {

    	ToDoList todo = new ToDoList();
    	
        todo.addTask(8, "Jitendra Malik");
        todo.addTask(7, "Chris Manning");
        todo.addTask(6, "Bruce Wayne");
        assertEquals("Bruce Wayne", todo.nextTask().getDescription());
        assertEquals("Chris Manning", todo.nextTask().getDescription());
        assertEquals(8, todo.nextTask().getPriority());
    	assertNull(todo.nextTask());
    }     
    
    // 1pt
    @Test
    public void problem8_MediumTest2() {
    	ToDoList todo = new ToDoList();
    	
        todo.addTask(8, "Jitendra Malik");
        todo.addTask(7, "Chris Manning");
        todo.addTask(6, "Bruce Wayne");
        todo.addTask(9, "Malik");
        todo.addTask(12, "Chris");
        todo.addTask(1, "Wayne");
        todo.nextTask();
        todo.nextTask();
        todo.nextTask();
        assertEquals("Jitendra Malik", todo.nextTask().getDescription());
        assertEquals("Malik", todo.nextTask().getDescription());
        assertEquals(12, todo.nextTask().getPriority());
    	assertNull(todo.nextTask());
    }     
    
    // 1pt
    @Test
    public void problem8_MediumTest3() {
    	ToDoList todo = new ToDoList();
    	
        todo.addTask(88, "A");
        todo.addTask(38, "B");
        todo.addTask(48, "C");
        todo.addTask(18, "D");
        todo.addTask(98, "E");
        todo.addTask(28, "F");
        todo.nextTask();
        todo.nextTask();
        todo.nextTask();
        assertEquals("C", todo.nextTask().getDescription());
        assertEquals("A", todo.nextTask().getDescription());
        assertEquals(98, todo.nextTask().getPriority());
    	assertNull(todo.nextTask());
    } 
    
    // 1pt
    @Test
    public void problem8_BigTest1() {
    	ToDoList todo = new ToDoList();
    	
        todo.addTask(8, "Z");
        todo.addTask(7, "B");
        todo.addTask(6, "C");
        todo.addTask(5, "D");
        todo.addTask(4, "E");
        todo.addTask(3, "F");
        todo.nextTask();
        todo.nextTask();
        todo.nextTask();
        assertEquals("C", todo.nextTask().getDescription());
        assertEquals("B", todo.nextTask().getDescription());
        assertEquals(8, todo.nextTask().getPriority());
    	assertNull(todo.nextTask());
    }      
    
    // 1pt
    @Test
    public void problem8_BigTest2() {

    	ToDoList todo = new ToDoList();
    	
        todo.addTask(-8, "Z");
        todo.addTask(-7, "B");
        todo.addTask(-6, "C");
        todo.addTask(-5, "D");
        todo.addTask(-4, "E");
        todo.addTask(-3, "F");
        todo.nextTask();
        todo.nextTask();
        todo.nextTask();
        assertEquals("D", todo.nextTask().getDescription());
        assertEquals("E", todo.nextTask().getDescription());
        assertEquals(-3, todo.nextTask().getPriority());
    	assertNull(todo.nextTask());    	
    	
    }      
    
    // 1pt
    @Test
    public void problem8_BigTest3() {
    	ToDoList todo = new ToDoList();
    	
        todo.addTask(28, "Z");
        todo.addTask(99, "B");
        todo.addTask(-22, "C");
        todo.addTask(15, "D");
        todo.addTask(1034, "E");
        todo.addTask(33, "F");
        todo.nextTask();
        todo.nextTask();
        assertEquals("Z", todo.nextTask().getDescription());
        assertEquals("F", todo.nextTask().getDescription());
        assertEquals(99, todo.nextTask().getPriority());
        todo.nextTask();
    	assertNull(todo.nextTask());
    }  
    
    //1pt
    @Test
    public void problem9_NegativeTest1() {
        RunwaySimulator rws = new RunwaySimulator();
        assertEquals("",rws.handleNextAction());
    }         
    
    //1pt
    @Test
    public void problem9_NegativeTest2() {
    	RunwaySimulator rws = new RunwaySimulator();
    	rws.addTakeOff("FlightA");
    	rws.addTakeOff("");
        rws.addLanding("FlightB");
        
        rws.handleNextAction();

        assertEquals("FlightA taking off", rws.handleNextAction());   
        assertEquals(" taking off", rws.handleNextAction()); 
        assertEquals("", rws.handleNextAction());
    }         

    //1pt
    @Test
    public void problem9_TrivialTest1() {
        RunwaySimulator rws = new RunwaySimulator();
        rws.addTakeOff("FlightA");
        rws.handleNextAction();
        
        rws.addTakeOff("FlightB");
        rws.handleNextAction();
        
        rws.addLanding("FlightC");
        rws.addLanding("FlightD");
        assertEquals("FlightC landing", rws.handleNextAction());
        assertEquals("FlightD landing", rws.handleNextAction());
        rws.addLanding("FlightE");
        assertEquals("FlightE landing", rws.handleNextAction());
    }         
    
    //1pt
    @Test
    public void problem9_TrivialTest2() {
        RunwaySimulator rws = new RunwaySimulator();
        rws.addTakeOff("FlightA");
        rws.addLanding("FlightC");
        rws.addLanding("FlightD");
        rws.addTakeOff("FlightB");
        rws.addLanding("FlightE");
        
        rws.handleNextAction();
        rws.handleNextAction();
        rws.handleNextAction();
        
        assertEquals("FlightA taking off", rws.handleNextAction());
        assertEquals("FlightB taking off", rws.handleNextAction());      
    }      
    
    // 1pt
    @Test
    public void problem9_MediumTest1() {
    	RunwaySimulator rws = new RunwaySimulator();
    	rws.addTakeOff("FlightA");
        rws.addTakeOff("FlightB");
        rws.addTakeOff("FlightC");
        rws.addTakeOff("FlightD");
        rws.addTakeOff("FlightE");

        assertEquals("FlightA taking off", rws.handleNextAction());
        assertEquals("FlightB taking off", rws.handleNextAction());
        assertEquals("FlightC taking off", rws.handleNextAction());
        assertEquals("FlightD taking off", rws.handleNextAction());
        assertEquals("FlightE taking off", rws.handleNextAction());
        assertEquals("", rws.handleNextAction());
    }     
    
    // 1pt
    @Test
    public void problem9_MediumTest2() {
    	RunwaySimulator rws = new RunwaySimulator();
    	rws.addLanding("FlightA");
        rws.addLanding("FlightB");
        rws.addLanding("FlightC");
        rws.addLanding("FlightD");
        rws.addLanding("FlightE");

        assertEquals("FlightA landing", rws.handleNextAction());
        assertEquals("FlightB landing", rws.handleNextAction());
        assertEquals("FlightC landing", rws.handleNextAction());
        assertEquals("FlightD landing", rws.handleNextAction());
        assertEquals("FlightE landing", rws.handleNextAction());
        assertEquals("", rws.handleNextAction());
    }     
    
    // 1pt
    @Test
    public void problem9_MediumTest3() {
    	RunwaySimulator rws = new RunwaySimulator();
    	rws.addLanding("FlightA");
        rws.addTakeOff("FlightB");
        rws.addLanding("FlightC");
        rws.addTakeOff("FlightD");
        rws.addLanding("FlightE");

        assertEquals("FlightA landing", rws.handleNextAction());
        assertEquals("FlightC landing", rws.handleNextAction());
        assertEquals("FlightE landing", rws.handleNextAction());
        assertEquals("FlightB taking off", rws.handleNextAction());
        assertEquals("FlightD taking off", rws.handleNextAction());
        assertEquals("", rws.handleNextAction());
    } 
    
    // 1pt
    @Test
    public void problem9_BigTest1() {
    	RunwaySimulator rws = new RunwaySimulator();
    	rws.addLanding("FlightA");
        rws.addTakeOff("FlightB");
        rws.addLanding("FlightC");
        rws.addTakeOff("FlightD");
        rws.addLanding("FlightE");

        assertEquals("FlightA landing", rws.handleNextAction());
        assertEquals("FlightC landing", rws.handleNextAction());
        assertEquals("FlightE landing", rws.handleNextAction());
        assertEquals("FlightB taking off", rws.handleNextAction());
        assertEquals("FlightD taking off", rws.handleNextAction());
        
        rws.addLanding("FlightP");
        rws.addTakeOff("FlightQ");
        rws.addLanding("FlightR");
        rws.addTakeOff("FlightS");
        rws.addLanding("FlightT");
        
        assertEquals("FlightP landing", rws.handleNextAction());
        assertEquals("FlightR landing", rws.handleNextAction());
        assertEquals("FlightT landing", rws.handleNextAction());
        assertEquals("FlightQ taking off", rws.handleNextAction());
        assertEquals("FlightS taking off", rws.handleNextAction());        
        
        assertEquals("", rws.handleNextAction());
    }      
    
    // 1pt
    @Test
    public void problem9_BigTest2() {
    	RunwaySimulator rws = new RunwaySimulator();
    	rws.addLanding("FlightA");
        rws.addTakeOff("FlightB");
        rws.addLanding("FlightC");
        rws.addTakeOff("FlightD");
        rws.addLanding("FlightE");
        rws.addLanding("FlightP");
        rws.addTakeOff("FlightQ");
        rws.addLanding("FlightR");
        rws.addTakeOff("FlightS");
        rws.addLanding("FlightT");
        
        assertEquals("FlightA landing", rws.handleNextAction());
        assertEquals("FlightC landing", rws.handleNextAction());
        assertEquals("FlightE landing", rws.handleNextAction());
        assertEquals("FlightP landing", rws.handleNextAction());
        assertEquals("FlightR landing", rws.handleNextAction());
        
        rws.handleNextAction();
        rws.handleNextAction();
        rws.handleNextAction();
        rws.handleNextAction();
        rws.handleNextAction();
        
        rws.addLanding("FlightU");
        rws.addLanding("FlightW");
        rws.addLanding("FlightX");
        rws.addLanding("FlightY");
        rws.addLanding("FlightZ");
        
        assertEquals("FlightU landing", rws.handleNextAction());
        assertEquals("FlightW landing", rws.handleNextAction());
        assertEquals("FlightX landing", rws.handleNextAction());
        assertEquals("FlightY landing", rws.handleNextAction());
        assertEquals("FlightZ landing", rws.handleNextAction());        
        
        assertEquals("", rws.handleNextAction());
    }      
    
    // 1pt
    @Test
    public void problem9_BigTest3() {
    	RunwaySimulator rws = new RunwaySimulator();
    	rws.addLanding("FlightA");
        rws.addTakeOff("FlightB");
        rws.addLanding("FlightC");
        rws.addTakeOff("FlightD");
        rws.addLanding("FlightE");
        rws.addLanding("FlightP");
        rws.addTakeOff("FlightQ");
        rws.addLanding("FlightR");
        rws.addTakeOff("FlightS");
        rws.addLanding("FlightT");
        rws.handleNextAction();
        rws.handleNextAction();
        rws.handleNextAction();
        rws.handleNextAction();
        rws.handleNextAction();
        rws.handleNextAction();
        
        assertEquals("FlightB taking off", rws.handleNextAction());
        assertEquals("FlightD taking off", rws.handleNextAction());
        assertEquals("FlightQ taking off", rws.handleNextAction());
        assertEquals("FlightS taking off", rws.handleNextAction());
        
        rws.handleNextAction();
        rws.handleNextAction();
        rws.handleNextAction();
        rws.handleNextAction();
        rws.handleNextAction();
        
        rws.addTakeOff("FlightU");
        rws.addTakeOff("FlightW");
        rws.addTakeOff("FlightX");
        rws.addTakeOff("FlightY");
        rws.addTakeOff("FlightZ");
        
        assertEquals("FlightU taking off", rws.handleNextAction());
        assertEquals("FlightW taking off", rws.handleNextAction());
        assertEquals("FlightX taking off", rws.handleNextAction());
        assertEquals("FlightY taking off", rws.handleNextAction());
        assertEquals("FlightZ taking off", rws.handleNextAction());        
        
        assertEquals("", rws.handleNextAction());
        assertEquals("", rws.handleNextAction());
        assertEquals("", rws.handleNextAction());
    }      
    
    //1pt
    @Test
    public void problem10_NegativeTest1() {
		String nonExistentFileName = "res/firstLetterDoesNotExist.txt";
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		System.setOut(new PrintStream(output));
		
		FirstLetterMap map = new FirstLetterMap(nonExistentFileName);
		
		String result = output.toString();
		assertEquals("File: " + nonExistentFileName + " not found", result);
    }         
    
    //1pt
    @Test
    public void problem10_NegativeTest2() {
    	FirstLetterMap map = new FirstLetterMap("res/lab7empty.txt");
		assertNull(map.getWordsThatStartWith('h'));
    }         
    
    //1pt
    @Test
    public void problem10_TrivialTest() {

    	FirstLetterMap map = new FirstLetterMap("res/firstLetter2.txt");
		assertEquals(
				"{a=[a, as], b=[but], d=[disappointment, down], e=[empty], f=[from], g=[great], h=[her], i=[it], j=[jar], l=[labelled], m=[marmalade], o=[of, one, orange], p=[passed], s=[she, shelves], t=[the, to, took], w=[was]}",
				map.toString());
    }      
    
    // 2pt
    @Test
    public void problem10_MediumTest() {
    	Set<String> expected = new TreeSet<>();
    	FirstLetterMap map = new FirstLetterMap("res/MidSize.txt");
    	assertEquals(
    			"{a=[a, also, american, among, an, and, app, apple, apples, april, as], b=[browser, by], c=[carbon, closed, commitment, company, companys, computer, consumer, creativity], d=[design, develop, digital], e=[ecosystem, electronics, emphasizing, environmentally, established], f=[footprint, for, founded, friendly, furthermore], h=[hardware, has, history], i=[i, icloud, ilife, imessage, in, inc, include, includes, including, industry, innovative, ios, ipad, ipados, iphone, ipod, is, it, its, itunes, iwork], j=[january, jobs], k=[known], l=[largest], m=[mac, macos, materials, media, mission, most, multinational, music], o=[of, online, operating, others], p=[personal, player, portable, productivity, products], q=[quality], r=[recognized, reduce, reputation, revenue, ronald], s=[safari, sell, services, since, size, smartphone, smartwatch, software, specializes, steve, store, strives, suites, sustainability, systems], t=[tablet, technology, that, the, throughout, to, tv, tvos], u=[unique, use], v=[valuable], w=[was, watch, watchos, wayne, web, well, widely, worlds, wozniak, wozniaks]}",
    			map.toString()
    			);
		expected.add("unique");
		expected.add("use");
		assertEquals(expected, map.getWordsThatStartWith('u'));
    }     
    
    // 2.5pt
    @Test
    public void problem10_BigTest1() {
    	FirstLetterMap map = new FirstLetterMap("res/BigTest1.txt");
    	Set<String> expected = new TreeSet<>();
    	expected = new TreeSet<>();
		expected.add("figures");
		expected.add("firm");
		expected.add("focused");
		expected.add("for");
		expected.add("freedom");

		
		assertNull(map.getWordsThatStartWith('z'));
		assertEquals(expected, map.getWordsThatStartWith('f'));
    }      
    
    // 2.5pt
    @Test
    public void problem10_BigTest2() {
    	FirstLetterMap map = new FirstLetterMap("res/BigTest2.txt");
    	Set<String> expected = new TreeSet<>();
    	
    	expected = new TreeSet<>();
		expected.add("a");
		expected.add("about");
		expected.add("achieve");
		expected.add("achievement");
		expected.add("advances");
		
		expected.add("after");
		expected.add("aimed");
		expected.add("aldrin");
		expected.add("american");
		expected.add("an");		
		
		expected.add("and");
		expected.add("apollo");
		expected.add("armstrong");
		expected.add("as");
		expected.add("astronauts");		
		expected.add("at");
		expected.add("attention");	
		
		assertEquals(expected,map.getWordsThatStartWith('a'));
		assertNull(map.getWordsThatStartWith('z'));
		assertNull(map.getWordsThatStartWith('q'));
    }      
    
}