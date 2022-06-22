package test.junit.com;

import src.junit.com.*;

import org.junit.*;
import static org.junit.Assert.*;

public class TestLinearRate {
  /** Test a single hour parking */
  @Test public void shouldDisplay120MinFor300cent() {
    RateStrategy rs = new LinearRateStrategy();
    assertEquals( 300 / 5 * 2, rs.calculateTime(300) ); 
  }
} 
