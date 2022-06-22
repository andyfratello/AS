package test.junit.com;

import src.junit.com.RateStrategy;

public class One2OneStrategy implements RateStrategy {

    @Override
    public int calculaTime(int insertedSoFar) {
        return insertedSoFar;
    }
}
