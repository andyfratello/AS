package test.junit.com;

import src.junit.com.*;
import org.junit.Before;
import org.junit.Test;
import src.junit.com.IllegalCoinException;

import static org.junit.Assert.*;

public class TestLinearRate {
    LinearRateStrategy r;
    /** Fixture for pay station testing. */
    @Before
    public void setUp() {
        r = new LinearRateStrategy();
    }

    @Test
    public void TestCalculaTime1aHoraLinear() throws IllegalCoinException {
        assertEquals(2, r.calculaTime(5));
    }

    @Test
    public void TestCalculaTime2aHora() throws IllegalCoinException {
        assertEquals(60, r.calculaTime(150));
    }

    @Test
    public void TestCalculaTimeSuccessivesHores() throws IllegalCoinException {
        assertEquals(120, r.calculaTime(300));
    }

}