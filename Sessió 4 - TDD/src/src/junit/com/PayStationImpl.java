package src.junit.com;

public class PayStationImpl implements PayStation {
  private int insertedSoFar;
  private int timeBought;

  /** the strategy for rate calculations */
  private RateStrategy rateStrategy;

  private PayStationFactory payStationFactory;

  public PayStationImpl(PayStationFactory payStationFactory) {
    this.payStationFactory = payStationFactory;
    this.rateStrategy = payStationFactory.crearEstrategia();
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
    timeBought = rateStrategy.calculateTime(insertedSoFar);
  }
  public int readDisplay() {
    return timeBought;
  }
  public Receipt buy() {
    Receipt r = payStationFactory.crearRebut(insertedSoFar); //new StandardReceipt(timeBought);
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

