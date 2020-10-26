package studio3;

import cse131.ArgsProcessor;

public class sieveOfEratosthenes {

	public static void main(String[] args) {
		
	 ArgsProcessor ap = new ArgsProcessor(args);
     int n = ap.nextInt("The size of the array?");
     int[] beforeSieve = new int[n];
     //fill the array& print it
     
     System.out.print("Array before selecting is ");
     
         for(int i=0;i < beforeSieve.length;++i) {
    	     beforeSieve[i]=i+2;
    	    System.out.print(beforeSieve[i]+" ");
            } 
         System.out.println();
         
         //starts to iterate
        
         for(int i = 0;i < beforeSieve.length-2;++i) {
        	 
      	   if(beforeSieve[i]!=0) {
      		 int step = beforeSieve[i];
      	     for (int j = i+step; j < beforeSieve.length-2;j=j+step) {
      	    	 beforeSieve[j]=0;

      	     }
      	   }
         }
         //end iteration
         //print the left numbers
                  
         System.out.print("Primes under "+n+" = ");
         for (int i=0;i<beforeSieve.length-2;++i) {
      	   if(beforeSieve[i]!=0) {
      		   System.out.print(beforeSieve[i]+", ");
	     }
       }
	}

}
	