package exercises2;

import cse131.ArgsProcessor;

public class Heads {

	public static void main(String[] args) {
		
        ArgsProcessor ap = new ArgsProcessor(args); 
		int N = ap.nextInt("How many times would you like to run this experiment?");
		
		int flipSum = 0;
		
		for (int i = 0; i < N;i++) {
		// what are the concepts?
        int numHeads = 0;
        int numFlips = 0;
      
		// now flip a coin until we see 10 heads
        
       
           while(numHeads!=10) {
			boolean isHeads = Math.random() < 0.5;
			if (isHeads) {
				numHeads = numHeads + 1;
			}
			numFlips = numFlips +1;
           }
		
		// here, numHeads should be 10
		
		System.out.println("Number of flips was " + numFlips);
		flipSum = flipSum + numFlips;
		System.out.println("Now the sum of flip times is "+flipSum);
		
        }
		System.out.println("Average of "+N+" times flips is " + (double)flipSum/N);
   	}

	}
