package test.junit.com;

import org.junit.*;
import src.junit.com.*;

import static org.junit.Assert.*;

public class TestPayStation {
  PayStation ps;
  /** Fixture for pay station testing. */
  @Before
  public void setUp() {
    One2OneStrategy linearRateStrategy = new One2OneStrategy();
    ps = new PayStationImpl(linearRateStrategy);
  }

  /**
   * Entering 5 cents should make the display report 2 minutes 
   * parking time.
  */
  @Test
  public void shouldDisplay2MinFor5Cents() throws IllegalCoinException {
    ps.addPayment( 5 );
    assertEquals( "Should display 2 min for 5 cents", 
                  5, ps.readDisplay() );
  }

  /**
   * Entering 25 cents should make the display report 10 minutes
   * parking time.
  */
  @Test
  public void shouldDisplay10MinFor25Cents() throws IllegalCoinException {
    ps.addPayment( 25 );
    assertEquals( "Should display 10 min for 25 cents", 
                  25, ps.readDisplay() );
    // 25 cent in 5 cent coins each giving 2 minutes parking
  }

  /** 
   * Verify that illegal coin values are rejected.
  */
  @Test(expected=IllegalCoinException.class)
  public void shouldRejectIllegalCoin() throws IllegalCoinException {
    ps.addPayment(17);
  }

  /**
   * Entering 10 and 25 cents should be valid and 
   * return 14 minutes parking 
  */
  @Test
  public void shouldDisplay14MinFor10And25Cents()
          throws IllegalCoinException {
    ps.addPayment( 10 );
    ps.addPayment( 25 );
    assertEquals( "Should display 14 min for 10+25 cents",
                  (10+25), ps.readDisplay() );
  }

  /**
   * Buy should return a valid receipt of the 
   * proper amount of parking time
  */
  @Test 
  public void shouldReturnCorrectReceiptWhenBuy() 
          throws IllegalCoinException {
    ps.addPayment(5);
    ps.addPayment(10);
    ps.addPayment(25);
    Receipt receipt;
    receipt = ps.buy();
    assertNotNull( "Receipt reference cannot be null",
                   receipt );
    assertEquals( "Receipt value must be 16 min.",
                  (5+10+25), receipt.value() );
  }
 
  /**
   * Receipts must be able to store parking time values
  */
  @Test 
  public void shouldStoreTimeInReceipt() {
    Receipt receipt = new ReceiptImpl(30);
    assertEquals( "Receipt can store 30 minute value",
                  30, receipt.value() );
  }

  /**
   * Buy for 100 cents and verify the receipt
  */
  @Test 
  public void shouldReturnReceiptWhenBuy100c() 
          throws IllegalCoinException {
    ps.addPayment(10);
    ps.addPayment(10);
    ps.addPayment(10);
    ps.addPayment(10);
    ps.addPayment(10);
    ps.addPayment(25);
    ps.addPayment(25);

    Receipt receipt;
    receipt = ps.buy();
    assertEquals((5*10+2*25), receipt.value() );
  }
  /**
   * Verify that the pay station is cleared after a buy scenario
  */
  @Test 
  public void shouldClearAfterBuy() 
          throws IllegalCoinException {
    ps.addPayment(25);
    ps.buy(); // I do not care about the result
    // verify that the display reads 0
    assertEquals( "Display should have been cleared",
                  0 , ps.readDisplay() );
    // verify that a following buy scenario behaves properly
    ps.addPayment(10); ps.addPayment(25);
    assertEquals( "Next add payment should display correct time",
                  (10+25), ps.readDisplay() );
    Receipt r = ps.buy();
    assertEquals( "Next buy should return valid receipt",
                  (10+25), r.value() );
    assertEquals( "Again, display should be cleared",
                  0 , ps.readDisplay() );
  }
  /**
   * Verify that cancel clears the pay station
   */
  @Test 
  public void shouldClearAfterCancel() 
          throws IllegalCoinException {
    ps.addPayment(10);
    ps.cancel();
    assertEquals( "Cancel should clear display",
                  0 , ps.readDisplay() );
    ps.addPayment(25);
    assertEquals( "Insert after cancel should work",
                  25 , ps.readDisplay() );
  }
}
