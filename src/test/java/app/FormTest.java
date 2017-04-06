package app;

import org.junit.*;
import static org.junit.Assert.*;

public class FormTest{

	@Test
	public void test1(){
		assertEquals(3, 2+1);
	}
	@Test
	public void test2(){
		Application a = new Application();
		assertEquals("Salary saved!", a.create("", "", 000));
	}
	@Test
	public void test3(){
		Application a = new Application();
		assertEquals("Salary saved!", a.create("M", "R", -1));
	}
	@Test
	public void test4(){
		Application a = new Application();
		assertEquals("Salary saved!", a.create("M", "R", 1000));
	}
}