package exercises3;

public class Shuffle {

	public static void main(String[] args) {
		String[] original = { "A", "B", "C", "D",
				"E", "F", "G", "H"
		};

		// print out original array
		for (int i=0; i < original.length; ++i) {
			System.out.println("Original at " + i + " is " + original[i]);
		}

		//
		// Follow the instructions on the web page to make a copy of
		// the original array, named shuffled, but with its elements
		// permuted from the original array.  The result is that the
		// shuffled array contains the same strings, but in a randomized
		// order.
		//
		//copy array
		   String[] copyOriginal = new String[original.length] ;
		
		   for (int i = 0; i < original.length;++i) {
			copyOriginal [i]= original [i]; 
			System.out.println("Copy of original at " + i + " is " + copyOriginal[i]);
		    }
        //shuffle
		   String[] shuffle = new String[original.length];
		   
		   for (int m=original.length-1; m>=0;--m) {
			int pickCard =(int)(Math.random()*(m+1));
			shuffle[m] = original[pickCard];
			for(int i = pickCard; i < original.length-1; ++i) {
				original[i]=original[i+1];
			}
			
		   }
		   
		//print the result
		   for (int i=0; i < shuffle.length; ++i) {
				System.out.println("Shuffle at " + i + " is " + shuffle[i]);
			}
	}
	
}