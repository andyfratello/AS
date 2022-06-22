package test.junit.com;
import org.mockito.Mock;
import src.junit.com.*;

import org.junit.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class TestPayStation {

  PayStation ps;

  /** Fixture for pay station testing. */
  @Before
  public void setUp() {
    ps = new PayStationImpl();
  }

  /**
   * Entering 5 cents should make the display report 2 minutes 
   * parking time.
  */
  @Test
  public void shouldDisplay2MinFor5Cents() throws IllegalCoinException {
    ps.addPayment( 5 );
    assertEquals( "Should display 2 min for 5 cents", 
                  2, ps.readDisplay() ); 
  }

  /**
   * Entering 25 cents should make the display report 10 minutes
   * parking time.
  */
  @Test
  public void shouldDisplay10MinFor25Cents() throws IllegalCoinException {
    ps.addPayment( 25 );
    assertEquals( "Should display 10 min for 25 cents", 
                  25 / 5 * 2, ps.readDisplay() );
    // 25 cent in 5 cent coins each giving 2 minutes parking
  }

  /** 
   * Verify that illegal coin values are rejected.
  */
  @Test(expected=IllegalCoinException.class)
  public void shouldRejectIllegalCoin() throws IllegalCoinException {
    ps.addPayment(17);
  }

  @Test
  public void shouldEnter10Coins() throws IllegalCoinException {
    ps.addPayment(10);
    ps.addPayment(25);
    assertEquals((35 / 5 * 2), ps.readDisplay());
  }

  @Test
  public void validReceipt() throws IllegalCoinException {
    ps.addPayment(5);
    ps.addPayment(10);
    ps.addPayment(25);
    assertEquals(16, ps.buy().value());
  }

  @Test
  public void receiptCanStoreValues() throws IllegalCoinException {
    ReceiptImpl receipt = new ReceiptImpl(10);
    assertEquals(4, receipt.value());
  }

  @Test
  public void buyFor100Cents() throws IllegalCoinException {
    ps.addPayment(25);
    ps.addPayment(25);
    ps.addPayment(25);
    ps.addPayment(25);
    assertEquals(40, ps.buy().value());
  }

  @Test
  public void clearingAfterABuyOperation() throws IllegalCoinException {
    ps.addPayment(25);
    ps.buy();
    assertEquals(0, ps.readDisplay());
  }

  @Test
  public void cancelResetsPayStation() throws IllegalCoinException {
    ps.addPayment(25);
    ps.cancel();
    assertEquals(0, ps.readDisplay());
  }

  @Test
  public void cancelResetsPayStationAndDisplaysCorrectlyNextOperation() throws IllegalCoinException {
    ps.addPayment(25);
    ps.cancel();
    ps.addPayment(5);
    assertEquals(2, ps.readDisplay());
  }

  @Test(expected=IllegalCoinException.class)
  public void empty0Coins() throws IllegalCoinException {
    ps.empty();
  }

  @Test
  public void emptyWithCoins() throws IllegalCoinException {
    ps.addPayment(25);
    ps.addPayment(10);
    assertEquals(35, ps.empty());
  }

  @Test(expected=IllegalCoinException.class)
  public void emptyTwice() throws IllegalCoinException {
    ps.addPayment(25);
    ps.addPayment(10);
    ps.empty();
    ps.empty(); // hi ha un 0 a totalCoins per tant salta excepció
  }
}
