package src.junit.com;

public class NewYorkFactory implements PayStationFactory {
    @Override
    public Receipt crearRebut(int insertedSoFar) {
        return new StandardReceipt(insertedSoFar);
    }

    @Override
    public RateStrategy crearEstrategia() {
        return new LinearRateStrategy();
    }
}
