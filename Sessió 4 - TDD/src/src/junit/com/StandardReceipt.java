package src.junit.com;


public class StandardReceipt implements Receipt {
  private int value;
  public StandardReceipt(int value) { this.value = value; }
  public int value() { return value;}
  public String print() {
	  String receiptContent = "----------------------------------";
	  receiptContent = receiptContent + "\n";
	  receiptContent = receiptContent + "-------- PARKING RECEIPT --------";
	  receiptContent = receiptContent + "\n";
	  receiptContent = receiptContent + "         Value " + value + " minutes";
	  receiptContent = receiptContent + "\n";
	  receiptContent = receiptContent + "----------------------------------";
	  return receiptContent; }

}
