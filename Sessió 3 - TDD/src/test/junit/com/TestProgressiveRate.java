package test.junit.com;

import org.junit.*;
import src.junit.com.*;

import static org.junit.Assert.*;

public class TestProgressiveRate {
    ProgessiveRateStrategy r;
    /** Fixture for pay station testing. */
    @Before
    public void setUp() {
        r = new ProgessiveRateStrategy();
    }

    @Test
    public void TestCalculaTime1aHora() throws IllegalCoinException {
        assertEquals(2, r.calculaTime(5));
    }

    @Test
    public void TestCalculaTime2aHora() throws IllegalCoinException {
        assertEquals(63, r.calculaTime(160));
    }

    @Test
    public void TestCalculaTimeSuccessivesHores() throws IllegalCoinException {
        assertEquals(121, r.calculaTime(355));
    }


}
