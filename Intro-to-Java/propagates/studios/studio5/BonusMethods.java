package studio5;

public class BonusMethods {
	/**
	 * Implemented correctly
	 * @param an integer n
	 * @return the sum of the positive integers n + (n-2) + (n-4) + ...
	 */
public static int sumDownBy2(int x){
	 int sum = 0;
	 if (x <= 0) {
		 return 0;
	 }
	 else {
		 for (int i = 0; x - i > 0 ; i = i + 2) {
			 sum = sum + x - i;
		 }
		 return sum;
	 }
	 
}	
/**
 * Implemented correctly
 * @param an positive integer,n
 * @return the sum 1 + 1/2 + 1/3 + ... + 1/(n-1) + 1/n
 */

public static double harmonicSum(int x) {
	double sum = 0;
	for (int i = 1; i <= x ; i = i + 1 ) {
		sum = sum + 1.0 / i;
	}
	return sum ;
		
}
/**
 * Implemented correctly
 * @param a non-negative integer, k
 * @return the sum 1 + 1/2 + 1/4 + 1/8 + ... + 1/Math.pow(2,k)
 */
public static double geometricSum(int k) {
	double sum = 0;
	for (int i = 0; i <= k ; i = i + 1 ) {
		sum = sum + 1.0 / Math.pow(2,i);
	}
	return sum ;
}
/**
 * Implemented correctly
 * @param an positive integer
 * @param other positive integer
 * @return the product of the two parameter
 */
public static int multPos(int j, int k) {
	int sum = 0;
	for (int i = 1; i <= k; i = i + 1) {
		sum = sum + j;
	}
	return sum;
}
/**
 * Implemented correctly
 * @param an integer
 * @param other integer
 * @return the product of two parameter
 */
public static int mult(int j, int k) {
	if (j < 0 & k < 0 ) {
		return  multPos(-j, -k);
	}
	else if (j > 0 & k > 0 ) {
		return multPos(j, k);
	}
	else {
		return -multPos(Math.abs(j), Math.abs(k));
	}
}
/**
 * Implemented correctly
 * @param one integer
 * @param one power >=0
 * @return the value of one integer to the power 
 */
public static int expt(int n, int k) {
	int product = 1;
	if(k == 0) {
		return 1;
	}
	for (int i = 1; i <= k; i++) {
		product = product * n;
	}
	return product;
}

}
