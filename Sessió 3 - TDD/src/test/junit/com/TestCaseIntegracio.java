package test.junit.com;

import org.junit.Before;
import org.junit.Test;
import src.junit.com.*;
import static org.junit.Assert.*;

public class TestCaseIntegracio {
    PayStation ps;

    @Test
    public void testNewYork() throws IllegalCoinException {
        LinearRateStrategy l = new LinearRateStrategy();
        ps = new PayStationImpl(l);
        ps.addPayment(25);
        ps.addPayment(25);
        ps.addPayment(25);
        ps.addPayment(25);
        ps.addPayment(25);
        ps.addPayment(25);
        assertEquals(60, ps.readDisplay());
    }

    @Test
    public void testBoston() throws IllegalCoinException {
        ProgessiveRateStrategy p = new ProgessiveRateStrategy();
        ps = new PayStationImpl(p);
        ps.addPayment(25);
        ps.addPayment(25);
        ps.addPayment(25);
        ps.addPayment(25);
        ps.addPayment(25);
        ps.addPayment(25);
        ps.addPayment(10);
        assertEquals(63, ps.readDisplay());
    }

}
