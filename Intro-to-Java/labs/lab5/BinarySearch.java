package lab5;


public class BinarySearch {
	/**
	 * Calculates the floored midpoint of two specified integer values.
	 * 
	 * For example: a: 300 and b: 400 returns 350. a: 300 and b: 401 also returns
	 * 350. a: 300 and b: 402 returns 351.
	 * 
	 * @param a a value
	 * @param b another value
	 * @return the midpoint of a and b
	 */
	public static int calculateMidPoint(int a, int b) {
		int c = (a+b)/2;
		return c;
	}

	/**
	 * Searches the specified sorted array for the value specified by key. If the
	 * array contains key, then it returns an index which holds the value, otherwise
	 * it returns -1. If array contains multiple elements with the specified key
	 * value, there is no guarantee which index will be returned.
	 * 
	 * If the array is unsorted, then the results are undefined.
	 * 
	 * This method must not mutate (that is: change the contents of) the specified
	 * array, nor would it have any real reason to do so.
	 * 
	 * @param array the array to be searched
	 * @param key   the value to be searched for
	 * @return an index of an occurrence of key, if it is contained in the array;
	 *         otherwise -1.
	 */
	public static int findIndexInSorted(String[] array, String key) {
//		if(Sort.isSorted(array)) {
           int startPoint = 0;
           int endPoint = array.length-1;
          while(startPoint<=endPoint) {
        	  int midPoint = calculateMidPoint(startPoint,endPoint);
        	  if(Strings.isGreaterThan(key, array[midPoint])) {
           	   startPoint = midPoint+1;
              }
              else if(Strings.isLessThan(key, array[midPoint])) {
           	   endPoint = midPoint-1;
              }
              else  {
           	   return midPoint;
              }
          }
       	   return -1;
//          }     
//		else {
//			return -10000;
//		}

	}
		
}
