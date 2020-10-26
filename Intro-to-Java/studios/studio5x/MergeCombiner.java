package studio5x;

import lab5.Sort;
import lab5.Strings;

public class MergeCombiner {
	/**
	 * Produces an array which is the sorted result of merging the two specified,
	 * sorted input arrays a and b.
	 * 
	 * For example, when the arrays { "E", "G", "N" } and {"B", "I", "S" } are
	 * passed to this method, the resulting array { "B", "E", "G", "I", "N", "S" }
	 * should be returned.
	 * 
	 * If either input array a or b is unsorted, then the results are undefined.
	 * 
	 * This method must not mutate (that is: change the contents of) the input
	 * arrays a or b, nor would it have any real reason to do so.
	 * 
	 * @param a
	 *            a sorted array
	 * @param b
	 *            another sorted array
	 * @return a new array which contains the contents of both a and b, sorted.
	 */
	public static String[] createMergeCombinedArray(String[] a, String[] b) {
		String [] combine = new String [a.length + b.length];
		if(Sort.isSorted(a) && Sort.isSorted(b)){
			int i=0;
			int j=0;
			int k=0;
				// start to compare one by one
				while(k < combine.length) {
					if (i < a.length && j < b.length) {
						if(Strings.isLessThan(a[i], b[j])) {
							combine[k] = a[i];
							i=i+1;
						}
						else {
							combine[k] = b[j];
							j=j+1;
						}
					}
					else if(i<a.length) {
						combine[k] = a[i];
						++i;
					}
					else if(j<b.length) {
						combine[k] = b[j];
						++j;
					}
					++k;
				}

			return combine;
			}// end of if sorted
		else {
			return combine;
		}
		}//end of this method

	}//end of this class
	
