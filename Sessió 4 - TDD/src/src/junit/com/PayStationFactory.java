package src.junit.com;

public interface PayStationFactory {
    public Receipt crearRebut(int insertedSoFar);

    public RateStrategy crearEstrategia();
}
