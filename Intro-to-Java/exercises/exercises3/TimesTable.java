package exercises3;

import cse131.ArgsProcessor;

public class TimesTable {

	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		int N = ap.nextInt("Max value for table?");
		
		//  Table should include rows and columns for 0...N  
		//     making N+1 rows and columns
		int [][] table = new int[N+1][N+1];
		
		for(int i=0; i < N+1;++i) {
			for(int j=0;j<N+1;++j) {
				table[i][j] = i * j; 
			}
		}
		
		//System.out.println(Arrays.deepToString(table));
		//
		//labels for each column
		System.out.print("   ");
		 for(int c=0;c<=N;++c) {
			 System.out.print(c+" ");
		 }
		 System.out.println();
		 System.out.println("---------------------");
		//produce a table row by row
		 
		for (int i = 0; i<=N; ++i) {
			//labels for each row
			System.out.print(i+" | ");
			for(int j=0;j<=N;++j) {
				
                int entry = table[i][j];
				if( entry < 10 ) {
					System.out.print(" "+table[i][j]+" ");
				}
				//print table
				else {
				System.out.print(table[i][j]+" ");
			    }
			}
				
			System.out.println();
		}
	}

}
