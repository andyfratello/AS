package src.junit.com;

public class BostonFactory implements PayStationFactory {
    @Override
    public Receipt crearRebut(int insertedSoFar) {
        return new BarCodeReceipt(insertedSoFar);
    }

    @Override
    public RateStrategy crearEstrategia() {
        return new ProgressiveRateStrategy();
    }
}
