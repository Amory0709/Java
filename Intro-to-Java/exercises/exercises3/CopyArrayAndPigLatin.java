package exercises3;

public class CopyArrayAndPigLatin {

	public static void main(String[] args) {
		String[] names = { "Alice", "Bob", "Carole", "David", "Elaine" };
		
		// first copy the above array into an array named copy
		//  Pretend the names array is large
		//  So we cannot just do the following (too much to type):
		//     String[] copy = { names[0], names[1], names[2] };
		//
		String [] copy = new String[names.length];
		for(int i = 0; i < names.length; ++i) {
			copy[i]=names[i];
			
		}
		// 
		// Follow the instructions on the web page to check
		// that your copy is correct.  Then cause the copy to store the
		// copied strings in "Pig Latin".  Do this by iteration without
		// assuming the length or contents of the names array.
		//
		for(int k = 0; k < copy.length;++k) {
			System.out.print(copy[k]+ " ");
			copy[k] = names[k]+"ay";
			System.out.println(copy[k]+ " ");
		}
	 
		
	}

}
