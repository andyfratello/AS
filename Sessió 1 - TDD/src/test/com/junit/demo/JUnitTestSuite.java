package test.com.junit.demo;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
  CalculatorTest.class,
  GreetingsTest.class
})

public class JUnitTestSuite {

}
