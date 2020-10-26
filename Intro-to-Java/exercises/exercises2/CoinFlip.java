package exercises2;

public class CoinFlip {

	public static void main(String[] args) {
		//
		// Use the random number generator
		//    (Math.random())
		// so that this program prints
		// heads or tails,
		// each with probability 0.5
		//
		// This program does not prompt the user
		//   for any input.  It simply prints
		// heads or tails
		//
      double headsOrTails = Math.random();
      if (headsOrTails<0.5) {
    	  System.out.println("Heads!");
    
      }
      else {
    	  System.out.print("Tails!");
    	  
      }
	}

}
