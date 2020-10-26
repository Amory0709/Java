package exercises2;

public class RandomAverages {

	public static void main(String[] args) {
		//
		// Write a loop that computes the average
		//     of 1, 2, ... 1000 doubles
		// In each iteration of that loop, print
		//     the average of the doubles generated
		//     thus far.
		//
		// Your code goes below here.
		int n = 0;
		double sum = 0.0;
		while (n<1000) {
			sum = sum + Math.random();
			n=n+1;
		}
		double average = sum/1000;
		System.out.println("The average of 1000 randoms is  "+average);
		
		//
		//  Some questions:
		//    1) How does the average change as your loop progresses?
		//    2) Can you write code in your loop that prints out the average only
		//         every 100 iterations, instead of each iteration?
		//
		
	}

}
