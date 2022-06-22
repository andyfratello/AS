package src.junit.com;

public class ReceiptImpl implements Receipt {
    private int minutes;

    public ReceiptImpl(int ISF) {
        minutes = ISF / 5 * 2;
    }

    @Override
    public int value() {
        return minutes;
    }
}
