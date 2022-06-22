package src.junit.com;


public class ProgessiveRateStrategy implements RateStrategy {

    @Override
    public int calculaTime(int insertedSoFar) {
        int time = 0;
        if (insertedSoFar >= 350) {
            insertedSoFar -= 350;
            time = 120 + insertedSoFar * 1 / 5;
        }
        else if (insertedSoFar >= 150) {
            insertedSoFar -= 150;
            time = 60 + insertedSoFar * 3 / 10;
        } else {
            time = insertedSoFar / 5 * 2;
        }
        return time;
    }
}
