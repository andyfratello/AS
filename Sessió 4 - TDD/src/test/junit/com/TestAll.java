package test.junit.com;

import src.junit.com.*;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith ( Suite.class )
  @Suite.SuiteClasses(
   { TestPayStation.class,
     TestLinearRate.class,
     TestProgressiveRate.class,
     TestIntegration.class } )


public class TestAll {
  // Dummy - it is the annotations that tell JUnit what to do...
}
