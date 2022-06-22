package test.junit.com;

import src.junit.com.*;

import org.junit.*;
import static org.junit.Assert.*;


public class TestProgressiveRate {
  RateStrategy rs;

  @Before public void setUp() {
    rs = new ProgressiveRateStrategy();
  }
  
  /** Test a single hour parking */
  @Test public void shouldGive60MinFor150cent() {
    // First hour: $1.5
    assertEquals( 60 /*minutes*/, rs.calculateTime(150) ); 
  }

  /** Test two hours parking */
  @Test public void shouldGive120MinFor350cent() {
    // Two hours: $1.5+2.0
    assertEquals( 2 * 60 /*minutes*/ , rs.calculateTime(350) ); 
  }

  /** Test three hours parking */
  @Test public void shouldGive180MinFor650cent() {
    // Three hours: $1.5+2.0+3.0
    assertEquals( 3 * 60 /*minutes*/ , rs.calculateTime(650) ); 
  }

  /** Test four hours parking */
  @Test public void shouldGive240MinFor950cent() {
    // Three hours: $1.5+2.0+3.0
    assertEquals( 4 * 60 /*minutes*/ , rs.calculateTime(950) ); 
  }
} 
