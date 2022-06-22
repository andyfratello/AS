package src.junit.com;

public class PayStationImpl implements PayStation {
  private int insertedSoFar;
  private int totalCoins;

  public void addPayment(int coinValue)
          throws IllegalCoinException {
    switch ( coinValue ) {
    case 5: break;
    case 10: break;
    case 25: break;
    default: 
      throw new IllegalCoinException("Invalid coin: "+coinValue);
    }
    insertedSoFar += coinValue;
    totalCoins += coinValue;
  }
  public int readDisplay() {
    return insertedSoFar / 5 * 2;
  }

  public ReceiptImpl buy() {
    ReceiptImpl r = new ReceiptImpl(insertedSoFar);
    insertedSoFar = 0;
    return r;
  }
  public void cancel() {
    insertedSoFar = 0;
  }

  public int empty() throws IllegalCoinException {
    if (totalCoins == 0) throw new IllegalCoinException("No coins");
    int tmp = totalCoins;
    totalCoins = 0;
    return tmp;
  }
}

