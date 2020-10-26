package exercises4;

import sedgewick.StdIn;
import cse131.ArgsProcessor;

public class Stats {

	public static void main(String[] args) {
		// prompt the user for the file to be used for this run
		ArgsProcessor.useStdInput("datafiles/average");

		//
		//  Read in the data from the opened file, computing the
		//     sum, average, count, max, and min
		//  of the data
		 double sum = StdIn.readDouble();
		 int count = 1;
		 double max = sum;
		 double min = sum;
		
		while(!StdIn.isEmpty()) {
			double d = StdIn.readDouble();
			sum = sum + d;
			count = count + 1;
			if(max < d) {
				max = d;
			}
			if(min > d) {
				min = d;
			}
		}
		  double average = sum/count;
		//
	     System.out.println("Sum "+sum);
	     System.out.println("Count "+count);
	     System.out.println("Max "+max);
	     System.out.println("Min "+min);
	     System.out.println("Average "+average);
		//  count is the number of doubles read from the file
		//  The other statistics should be clear from their names
		//

	}

}
