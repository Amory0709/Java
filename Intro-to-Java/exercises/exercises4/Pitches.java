package exercises4;

import cse131.ArgsProcessor;

public class Pitches {

	public static void main(String[] args) {
		// encoding has 0 as concert A
		//    1 would be Bb, just above A
		//   -1 would be Ab, just below A
       ArgsProcessor ap = new ArgsProcessor(args);
       
       int pitch = ap.nextInt("What pitch do you want?");
       int pitch2 = ap.nextInt("Another pitch do you want?");
       
       double freq = 440.0 * Math.pow(2, pitch/12.0);
       double freq2 = 440.0 * Math.pow(2, pitch2/12.0);
       double ratio = freq2/freq;
       System.out.println("Frequency"+freq);
       System.out.println("Up a diatonic fifth frequency"+freq2);
       System.out.println("Ratio is"+ratio);
	}

}
 