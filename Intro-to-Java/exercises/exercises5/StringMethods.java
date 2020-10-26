package exercises5;

public class StringMethods {
	
	//
	// Below are the methods defined for this exercise
	//   The names are not prescribed in the assignment, so choose
	//   names you like (that are meaningful)
	//
	
	//
	// First one is completed for you:
	//
	
	public static String selfConcat(String s) {
		return multiConcat(s,2);
	}
	/**
	 * 
	 * @param s the input string
	 * @param n the of copies
	 * @return n copies of s
	 */
	public static String multiConcat(String s,int n) {
	    String[] array = new String [n];
	    for(int i = 0; i < n ;++i) {
	    	array[i] =  s;
	    }
	    return join(array," ");
	}
	
	public static String join(String[] array, String joiner) {
		//special case, array is of 0 length
		if(array.length==0) {
			return "";
		}
		String ans = array[0];
		for(int i = 1; i  < array.length; ++i) {
			ans = ans + joiner + array[i];
		}
		return ans;
	}
	
	
	public static void main(String[] args) {
		
		//
		// Testing the methods
		//
		
		System.out.println(selfConcat("echo"));
		System.out.println(multiConcat("echo",3));
		String s = "How are you today?";
		String [] aSplit = s.split(" ");
		for(String a : aSplit ) {
			 System.out.println("A word:  "+a);
		}
		System.out.println("Back "+join(aSplit," "));
	}
	
	

}
