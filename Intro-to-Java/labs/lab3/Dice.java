package lab3;

import cse131.ArgsProcessor;

public class Dice {

	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
      int diceNum = ap.nextInt("How many dice will be used in this simulation?");
      int timesNum = ap.nextInt("How many times will the dice be thrown?");
      int[][] simulation = new int[timesNum][diceNum];
      int sum[] = new int[timesNum];
     //roll the dice 
      for(int i = 0; i < timesNum; ++i) {
    	  int sumOfRow = 0;
    	  System.out.print("round "+(i+1)+ " : ");
    	   for(int j = 0; j < diceNum;++j) {
    		   simulation[i][j] = (int)(Math.random() * 6+1);
    		   System.out.print(" "+simulation[i][j]+" ");
    		   sumOfRow = sumOfRow + simulation[i][j];
    	   }
    	   System.out.println("     Sum of Round "+(i+1)+ " is "+sumOfRow);
    	   sum[i] = sumOfRow;
       }
      //end of the roll
      
      //count round that has the same values
      int sameNumTimes = 0;
     
      for(int i = 0; i < timesNum; ++i) {
    	  int sameNumInOneRound = 0;
   	    //scan through every column in a row
    	  for(int j = 1; j < diceNum;++j) {
             if (simulation[i][j] == simulation[i][j-1]) {
         	  sameNumInOneRound = sameNumInOneRound + 1;
         	  System.out.println("Same value in round " + (i+1) +" ");
             }
   	       }
    	  //determine if it has the same dices
   	    if(sameNumInOneRound == diceNum-1) {
   	    	sameNumTimes = sameNumTimes + 1;
   	    }
      }
      System.out.println("Number of Rounds that have the same number: "+sameNumTimes);
      double ratioOfSame = (double)sameNumTimes/timesNum;
      System.out.println(ratioOfSame *100 + "% of the total rolling times has the same number.");
      //end of count
      
      //count rounds that have same sum
      System.out.println("Sum \t Number of times Sum was seen \t frequency");
      for(int i = 0; i < timesNum; ++i) {
    	  int sameSum = 1;
        if(sum[i]!=0) { 
    	 for(int j = i+1; j < timesNum; ++j) {
    		  if(sum[i] == sum[j]) {
    			  sameSum = sameSum + 1;
    			  sum[j]=0;
    		  }
    	    }//for j loop
    	 System.out.println(sum[i]+" \t             "+sameSum+"    \t            "+(double)sameSum*100/timesNum+"% ");  
        }  
      }
     
	}
}
