package fibonacci;

public class Fibonacci {
	//f(n)=f(n-1)+f(n-2)
	//if n = 1, f(n)=n
	/**
	 * Below copy your solution to recursive Fibonacci from studio
	 * @param n
	 * @return fib(n), computed recursively
	 */
	public static int recursive(int n) {
		if(n <=1) {
			return n;
		}
		else {
			return recursive(n-1)+recursive(n-2);
		}
	}
	
	/**
	 * Below write your solution to Fibonacci, using iteration
	 * @param n
	 * @return fib(n), computed iteratively
	 */
	public static int iterative(int n) {	
		if(n==0) {
			return 0;
		}
		if(n==1) {
			return 1;
		}
		int [] store = new int [n];
		store[0] = 0;
		store[1] = 1;
		for(int i = 2; i < n; ++i) {
			store[i] = store[i-1]+store[i-2];
		}
			return store[n-1]+store[n-2];
	}

}
