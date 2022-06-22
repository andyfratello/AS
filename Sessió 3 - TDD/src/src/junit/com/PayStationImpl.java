package src.junit.com;

public class PayStationImpl implements PayStation {
  private int insertedSoFar;
  private int timeBought;
  private RateStrategy r;

  public PayStationImpl(RateStrategy rateStrategy) {
    r = rateStrategy;
  }

  public void addPayment( int coinValue ) 
          throws IllegalCoinException {
    switch ( coinValue ) {
    case 5: break;
    case 10: break;  
    case 25: break;  
    default: 
      throw new IllegalCoinException("Invalid coin: "+coinValue);
    }
    insertedSoFar += coinValue;
    timeBought = r.calculaTime(insertedSoFar); //insertedSoFar / 5 * 2;
  }
  public int readDisplay() {
    return timeBought;
  }
  public Receipt buy() {
    Receipt r = new ReceiptImpl(timeBought);
    reset();
    return r;
  }
  public void cancel() {
    reset();
  }
  private void reset() {
    timeBought = insertedSoFar = 0;
  }
}

