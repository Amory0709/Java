// Student ID:466837 
//Student Name: Amori_Han

package lab2;

import cse131.ArgsProcessor;

public class NimGame {

	public static void main(String[] args) {
	
        ArgsProcessor ap = new ArgsProcessor(args);
        int originalStickNum = ap.nextInt("How many sticks do you want to have? ");
        boolean gameOrder = ap.nextBoolean("Do you want to move the sticks first?(True/False)");
		int computerNum;
        
		//Human starts first
      if( gameOrder) {
        	int stickNum = originalStickNum;
        	int roundNum = 0;
            System.out.println("Human starts");
        	while(stickNum > 0) {
            
        	//human's round
            System.out.print("Round "+roundNum + ", "+stickNum+" sticks at start, " );
        		
            int humanNum = ap.nextInt("How many sticks do you want to move this time?");
 
              while( humanNum< 1 || humanNum > 2) {
              	System.out.println("Choose only from 1 and 2!");
              	humanNum = 0;
                humanNum = ap.nextInt("How many sticks do you want to move this time?");
              	}
        		
        		if(stickNum>1) {
        		  stickNum = stickNum - humanNum;
        		  roundNum = roundNum + 1;
        		System.out.println("human took "+humanNum+", so "+ stickNum+" sticks remain");
        	    }
        	    else if(stickNum == 1){
        		  stickNum = stickNum - 1;  
        		  roundNum = roundNum + 1;
        		  System.out.println("human took 1, so "+ stickNum+" sticks remain");	
        	    }
        	    else if (stickNum == 0) {
        			System.out.println("Human wins");
        		}
        			
        	//Computer's round
        	  if(stickNum != 0) {
        	System.out.print("Round "+roundNum + ", "+stickNum+" sticks at start, " );
        	
        		if(Math.random() < 0.5|| stickNum == 1) {
        			computerNum = 1;
        		}
        		else {
        			computerNum = 2;
        		}
        		stickNum = stickNum -computerNum;
        		roundNum = roundNum + 1;
        		System.out.println("computer took "+computerNum+", so "+ stickNum+" sticks remain");
        		if (stickNum == 0) {
        			System.out.println("Computer wins");
        		}
        	  }
           }
	 }
        
        //Computer starts first
   else {
	     int stickNum = originalStickNum;
   	     int roundNum = 0;
         System.out.println("Cumputor starts");
   	     
         while(stickNum > 0) {
       
       	//Computer's round
   	    	System.out.print("Round "+roundNum + ", "+stickNum+" sticks at start, " );
   	         if(Math.random() < 0.5 || stickNum == 1 ) {
   			     computerNum = 1;
   		     }
   		     else {
   			     computerNum = 2;
   		     }
   		  stickNum = stickNum -computerNum;
   		  roundNum = roundNum + 1;
   		  System.out.println("computer took "+computerNum+", so "+ stickNum+" sticks remain");
   		     if (stickNum == 0) {
   			  System.out.println("Computer wins");
   		     }
   		
   	      //human's round
   	 if(stickNum != 0) {
   		  System.out.print("Round "+roundNum + ", "+stickNum+" sticks at start, " );
  		int humanNum = ap.nextInt("How many sticks do you want to move this time?");

  		    while( humanNum< 1 || humanNum > 2) {
           	System.out.println("Choose only from 1 and 2!");
           	humanNum = 0;
             humanNum = ap.nextInt("How many sticks do you want to move this time?");
           	}
  		
  		if(stickNum>1) {
  		  stickNum = stickNum - humanNum;
  		  roundNum = roundNum + 1;
  		System.out.println("human took "+humanNum+", so "+ stickNum+" sticks remain");
  	    }
  	    else if(stickNum == 1){
  		  stickNum = stickNum - 1;  
  		  roundNum = roundNum + 1;
  		  System.out.println("human took 1, so "+ stickNum+" sticks remain");	
  	    }
  	     if (stickNum == 0) {
  			System.out.println("Human wins");
  		 }
       }
      }
	 }
  }
}

