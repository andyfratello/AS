package src.junit.com;

public interface RateStrategy {
  /**
   return the number of minutes parking time the provided 
   payment is valid for.  
   @param amount payment in some currency.
   @return number of minutes parking time.
   */
  public int calculateTime( int amount );
}

