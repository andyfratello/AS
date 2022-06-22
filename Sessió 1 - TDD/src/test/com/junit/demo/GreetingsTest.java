package test.com.junit.demo;
import src.com.junit.demo.*;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class GreetingsTest {

	private Greetings g;
	  
	 @Before
	 public void setUp() throws Exception {
	  g = new Greetings();
	 }
	 
	 @Test
	 public void testsayHello() {
	  assertEquals("Hello", g.sayHello());
	 }
}
