package com.IndustrialDemo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class IndustrialDemoApplicationTests {

	//creating an instance
	private Calculator c = new Calculator();
	
	@Test
	void contextLoads() {
	}

	@Test
	@Disabled     //test cases disable karva mate..
	void testSum() {
		
		//expected value
		int expectedvalue=23;
		
		//actual
		int actualvalue = c.doSum(8,9, 6);
		assertThat(actualvalue).isEqualTo(expectedvalue);
		
	}
	 
	@Test 
	void testProdcuct() {
		
		//expected value
		int expectedvalue= 81;
		
		//actual
		int actualvalue= c.doProduct(9, 9);
		assertThat(actualvalue).isEqualTo(expectedvalue);
	}
	
	@Test
	void testCompare() {
	
		//actual result
		boolean actualvalue = c.doCompare(8, 8);
		assertThat(actualvalue).isTrue();
		
	}
	
	
}
