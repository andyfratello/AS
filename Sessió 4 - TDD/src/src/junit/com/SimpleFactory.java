package src.junit.com;

import test.junit.com.One2OneRateStrategy;

public class SimpleFactory implements  PayStationFactory {

    @Override
    public Receipt crearRebut(int insertedSoFar) {
        return new StandardReceipt(insertedSoFar);
    }

    @Override
    public RateStrategy crearEstrategia() {
        return new One2OneRateStrategy();
    }
}
