package test.com.junit.demo;
import src.com.junit.demo.*;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
 
public class CalculatorTest {
 
 private Calculator calc;
  
 @Before
 public void setUp() throws Exception {
  calc = new Calculator();
 }
 
 @After
 public void tearDown() throws Exception {
  calc = null;
 }
 
 @Test
 public void testMultiply() {
  double result = calc.multiply(2.5, 100);
  assertEquals(250, result, 0);
 }
 
 @Test
 public void testDivide() {
  double result = calc.divide(100, 10);
  assertEquals(10, result, 0);
   
 }
 
 @Test
 public void testDivideWithTolerance() {
  double result = calc.divide(345, 100);
  assertEquals(3.4, result, 0.1);
   
 }
  
 @Test(expected = ArithmeticException.class)
 public void testDivideByZero() {
  calc.divide(100.5, 0);
 }

 @Test
 public void testSuma() {
  double result = calc.suma(2, 10);
  assertEquals(12, result, 0);
 }

 @Test
 public void testResta() {
  double result = calc.resta(10, 2);
  assertEquals(8, result, 0);
 }

 @Test(expected = ArithmeticException.class)
 public void testRestaMesGranElSegon() {
  calc.resta(2, 10);
 }

 @Test
 public void testFactorialZero() {
  int result = calc.factorial(0);
  assertEquals(1, result);
 }

 @Test(expected = ArithmeticException.class)
 public void testFactorialNegatiu() {
  calc.factorial(-2);
 }

 @Test
 public void TestFactorialPositiu() {
  int result = calc.factorial(5);
  assertEquals(120, result);
 }

}
