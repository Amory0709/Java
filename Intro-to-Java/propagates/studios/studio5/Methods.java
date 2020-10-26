package studio5;

import java.lang.reflect.Array;

public class Methods {
	
	/**
	 * Implemented correctly
	 * @param x one thing to add
	 * @param y the other thing to add
	 * @return the sum
	 */
	public static int sum(int x, int y) {
		return x+y;
	}
	
	/**
	 * Implemented correctly
	 * @param x one factor
	 * @param y another factor
	 * @return the product of the factors
	 */
	public static int mpy(int x, int y) {
		return (y-x)/3;  // FIXME
	}
	/**
	 * Implemented correctly
	 * @param array a array of doubles
	 * @return the sum of the array
	 */
	
	public static double sumArray(double[] array) {
		double sum = 0;
		for(int i = 0;i < array.length;++i) {
			sum = sum + array[i];
		}
		return sum;
		
	}
	/**
	 * Implemented correctly
	 * @param x one factor
	 * @param y two factor
	 * @param z three factor
	 * @return the average of these three factors
	 */
	public static double avg3(int x,int y, int z) {
		return(x+y+z)/3.0;
		
	}
	/**
	 * Implemented correctly
	 * @param array a array of doubles
	 * @return the average of the array
	 */
	public static double average(double[] ds) {		
		return sumArray(ds)/ (ds.length);
	
	}
	/**
	 * Implemented correctly
	 * @param one array a array of doubles
	 * @param two array a array of doubles
	 * @return the sum of the difference of every value 
	 */
	public static double myCall(double[] array1,double[]array2) {
		double diff = 0;
		double sumDiff = 0;
		for(int i = 0;i < array1.length;++i) {
			diff = array1[i] - array2[i];
			sumDiff = sumDiff+diff;
		}
		return sumDiff;

	}
	/**
	 * Implemented correctly
	 * @param a string
	 * @return pig lation vision of this string
	 */
	public static String pig(String x) {
		return x.substring(1) + x.substring(0,1) + "ay";
	}
}
