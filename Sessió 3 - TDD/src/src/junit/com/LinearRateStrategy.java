package src.junit.com;

public class LinearRateStrategy implements RateStrategy {

    @Override
    public int calculaTime(int insertedSoFar) {
        return insertedSoFar / 5 * 2;
    }

}
