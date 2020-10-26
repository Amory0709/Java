package mario;

import cse131.ArgsProcessor;

public class Mario {

	public static void main(String[] args) {
		
		//
		// Surprise!  This part is done for you.
		//    Don't change this and don't ask for any other inputs
		//      or testing will fail
		//
		ArgsProcessor ap = new ArgsProcessor(args);
		int size    = ap.nextInt("What size mountain do you want?");
		int pattern = ap.nextInt("What pattern (1, 2, 3, or 4)?");
		
		if (size < 1)
			throw new IllegalArgumentException("Size must be at least 1");
		if (pattern < 1 || pattern > 4)
			throw new IllegalArgumentException("Invalid pattern, must be 1, 2, 3, or 4.  Mario aborts");
		
		//
		// Create the mountain by printing to System.out
		//
		if(pattern == 1) {
			for(int i = 0;i < size;++i) {
			  for(int j = 0; j < size-i-1;++j) {
				  System.out.print(" ");
			  }
			  for(int k = 0; k < i+1;++k) {
				  System.out.print("#");
			  }
			  System.out.println();
			}
		}//end of pattern1
		if(pattern == 2) {
			for(int i = 0;i < size;++i) {
			    for(int k = 0; k < i+1;++k) {
					  System.out.print("#");
				  }
				for(int j = 0; j < size-i-1;++j) {
				  System.out.print(" ");
			    }
			  
			  System.out.println();
			}
		}//end of pattern 2	
		if(pattern == 3) {
			for(int i = 0;i < size;++i) {
			  for(int j = 0; j < i;++j) {
				  System.out.print(" ");
			  }
			  for(int k = 0; k <size-i;++k) {
				  System.out.print("#");
			  }
			  System.out.println();
			}
		}//end of pattern3
		if(pattern == 4) {
			for(int i = 0;i < size;++i) {
			  for(int k = 0; k <size-i;++k) {
					  System.out.print("#");
			  }
			  for(int j = 0; j < i;++j) {
				  System.out.print(" ");
			  }
			  
			  System.out.println();
			}
		}//end of pattern4
		
	}

}
