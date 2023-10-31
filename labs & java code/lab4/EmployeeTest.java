package labs.lab4;

import static org.junit.Assert.*;

import org.junit.Test;

public class EmployeeTest {
	private final static double EPSILON = 1e-5;
	
	@Test
    public void testConstructor() {
		Employee tom = new Employee("Tom", 15.0, 30, 5);
		assertEquals("Tom", tom.getName());
		assertEquals(15.0, tom.getPayRate(),EPSILON);
		assertEquals(30.0, tom.getHoursWorked(),EPSILON);
    }
	
	
	@Test
    public void testName() {
		Employee tom = new Employee("Tom", 15.0, 30, 5);
		assertEquals("Tom", tom.getName());
		tom.setName("Kitty");
		assertEquals("Kitty",tom.getName());
    }
	
	
	@Test
	public void testPayRate() {
		Employee tom = new Employee("Tom", 15.0, 30, 5);
		assertEquals(15.0,tom.getPayRate(),EPSILON);
		tom.setPayRate(12.0);
		assertEquals(12.0, tom.getPayRate(),EPSILON);
	}
	
	
	@Test
	public void testHoursWorked() {
		Employee tom = new Employee("Tom", 15.0, 30, 5);
		assertEquals(30,tom.getHoursWorked(),EPSILON);
		tom.setHoursWorked(60);
		assertEquals(60,tom.getHoursWorked(),EPSILON);
	}
	
	
	@Test
	public void testProvisional() {
		Employee tom = new Employee("Tom", 15.0, 30, 5);
		assertTrue(tom.isProvisional());
		Employee kitty = new Employee("Kitty", 15.0, 30, 90);
		assertTrue(kitty.isProvisional());
		Employee lendy = new Employee("Lendy", 15.0, 30, 100);
		assertFalse(lendy.isProvisional());
	}
}
