package exercises2;

public class Die {

	public static void main(String[] args) {

		//
		// Use the random number generator
		//    (t)
		// so that this program prints out one of
		// the following integers:
		//   1 2.0 3.0 4.0 5.0 6.0
		// with equal probability
		//
		// Note this program does not prompt the user
		//  for input, it just produces one of the
		//  above integers as output, as if by 
		//  throw of a die
		//
		double t = Math.random();
         if(t <= 1.00/6.00) {
        	 System.out.println("1");
         }
         if(t > 1.00/6.00 && t <= 2.00/6.00) {
        	 System.out.println("2");
         }
         if(t > 2.00/6.00 && t <= 3.00/6.00) {
        	 System.out.println("3");
         }
         if(t > 3.00/6.00 && t <= 4.00/6.00) {
        	 System.out.println("4");
         }
         if(t > 4.00/6.00 && t <= 5.00/6.00) {
        	 System.out.println("5");
         }
         if(t > 5.00/6.00 && t <= 6.00/6.00) {
        	 System.out.println("6");
         }
	}

}
