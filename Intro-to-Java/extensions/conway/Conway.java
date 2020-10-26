package conway;

/**
 * 
 *
 */
public class Conway {

    private int rows;
    private int cols;
    private boolean [][] status;
    
    /**
     * 
     * @param rows
     * @param cols
     */
	public Conway(int rows, int cols){
		this.rows = rows;
		this.cols = cols;
		this.status = new boolean [rows][cols];
		for(int i = 0; i < rows; ++i) {
			for(int j = 0; j < cols; ++j) {
				this.status[i][j] = false;
			}
		}
	}

	/**
	 * 
	 * @return
	 */
	public int getRows(){
		return this.rows;             
	}

	/**
	 * 
	 * @return
	 */
	public int getColumns(){
		return this.cols;             
	}

	/**
	 * Sets the current status of the cell at (row, col)
	 * @param b if true, the cell is alive; if false, the cell is dead 
	 * @param row
	 * @param col
	 */
	public void setLiveness(boolean b, int row, int col){
		if(row < this.rows && col < this.cols) {
			this.status[row][col] = b;
		}
	}


	/**
	 *  
	 * @param row
	 * @param col
	 * @return whether or not a cell at a specific row and column is alive. 
	 *    If row or col is out of bounds, you must return false.
	 */
	public boolean isAlive(int row, int col){
//		if(row >= this.rows || col >= this.cols) {
//			return false;
//		}
//		else {
//			return this.status[row][col];
//		}
		if(row >= 0 && row < this.rows) {
			if(col >= 0 && col < this.cols) {
				return this.status[row][col];
			}
			else {
				return false;
			}
		}else {
			return false;
		}
	}


	/**
	 * Make every cell not alive
	 */
	public void clear(){
		for(int i = 0; i < rows; ++i) {
			for(int j = 0; j < cols; ++j) {
				this.status[i][j] = false;
			}
		}
	}


	/**
	 * Consider the 3x3 cell array that has the cell at (row, col) at its center.
	 * Let's call all cells but that center cell the neighbors of that center cell.
	 * This method returns the number of neighbors that are alive.
	 * 
	 *   n  n  n
	 *   n  c  n
	 *   n  n  n
	 *   
	 *  Above, if c represents the cell at (row, col), each n is
	 *  a neighbor of c, according to the above definition.
	 *  The result is at most 8 and at least 0.
	 * 
	 * @param row
	 * @param col
	 * @return the number of living neighbors
	 */
	public int countLivingNeighbors(int row, int col){
		int numAlive = 0;
		boolean c1 = (col-1) < 0;
		boolean c2 = (col+1) >= this.cols;
		boolean r1 = (row-1)<0;
		boolean r2 = (row+1) >= this.rows;	
		
		if(!c1 && !r1) {
			if(this.status[row-1][col-1]) {
				numAlive = numAlive +1;
			}
		}
		if(!r1) {
			if(this.status[row-1][col] ) {
				numAlive = numAlive +1;
			}
		}
		if(!c2 && !r1) {
			if(this.status[row-1][col+1] ) {
				numAlive = numAlive +1;
			}
		}
		if(!c1) {
			if(this.status[row][col-1] ) {
				numAlive = numAlive +1;
			}
		}
		if(!c2) {
			if(this.status[row][col+1] ) {
				numAlive = numAlive +1;
			}
		}
		if(!r2 && !c1) {
			if(this.status[row+1][col-1] ) {
				numAlive = numAlive +1;
			}
		}
		if(!r2) {
			if(this.status[row+1][col]) {
				numAlive = numAlive +1;
			}
		}
		if(!r2 && !c2) {
			if(this.status[row+1][col+1] ) {
				numAlive = numAlive +1;
			}
		}
		
		return numAlive;
	}

	/**
	 * Executes a generation of life.  Be sure to read the specification
	 * for this assignment, because it points out a common mistake students
	 * make when implementing this method.
	 * 
	 */
	public void step(){
		Conway nextConway = new Conway(this.rows,this.cols);
		for(int i = 0; i < this.rows; ++i) {
			for(int j = 0; j < this.cols; ++j) {
				int liveNeigh = countLivingNeighbors(i,j);
				//check for the status now. if it is live
				if(isAlive(i,j)) {
					if(liveNeigh < 2 || liveNeigh > 3) {
						nextConway.setLiveness(false, i, j);
					}
					else {
						nextConway.setLiveness(true, i, j);
					}
				}
				//if it is dead
				else {
					if(liveNeigh == 3) {
						nextConway.setLiveness(true, i, j);
					}
					else {
						nextConway.setLiveness(false, i, j);
					}
				}	
			}
		}
		this.status = nextConway.status;
	}

	/**
	 * creates a blinker
	 */
	public void blinker() {

		if (this.getRows() < 3 || this.getColumns() < 3) {
			System.out.println("Grid is too small for premade pattern Blinker. " +
					"Conway must be at least 3x3");
		}
		else {
			this.setLiveness(true, 1, 0);
			this.setLiveness(true, 1, 1);
			this.setLiveness(true, 1, 2);
		}
	}

	public void fourBlinkers() {
		clear();
		if (this.getRows() < 9 || this.getColumns() < 9) {
			System.out.println("Grid is too small for premade pattern Four Blinkers. " +
					"Conway must be at least 9x9");
		}
		else {
			for (int i = 3; i < 6; i++) {
				for (int j = 3; j < 6; j++) {
					this.setLiveness(true, i, j);
				}
			}
		}
	}


	public void gosperGliderGun() {
		clear();
		if (this.getRows() < 50 || this.getColumns() < 50) {
			System.out.println("Grid is too small for premade pattern Gosper Glider Gun. " +
					"Conway must be at least 50x50");
		}
		else {
			this.setLiveness(true,0,27);
			this.setLiveness(true,1,25);
			this.setLiveness(true,1,27);
			this.setLiveness(true,2,15);
			this.setLiveness(true,2,16);
			this.setLiveness(true,2,23);
			this.setLiveness(true,2,24);
			this.setLiveness(true,2,37);
			this.setLiveness(true,2,38);
			this.setLiveness(true,3,14);
			this.setLiveness(true,3,18);
			this.setLiveness(true,3,23);
			this.setLiveness(true,3,24);
			this.setLiveness(true,3,37);
			this.setLiveness(true,3,38);
			this.setLiveness(true,4,3);
			this.setLiveness(true,4,4);
			this.setLiveness(true,4,13);
			this.setLiveness(true,4,19);
			this.setLiveness(true,4,23);
			this.setLiveness(true,4,24);
			this.setLiveness(true,5,3);
			this.setLiveness(true,5,4);
			this.setLiveness(true,5,13);
			this.setLiveness(true,5,17);
			this.setLiveness(true,5,19);
			this.setLiveness(true,5,20);
			this.setLiveness(true,5,25);
			this.setLiveness(true,5,27);
			this.setLiveness(true,6,13);
			this.setLiveness(true,6,19);
			this.setLiveness(true,6,27);
			this.setLiveness(true,7,14);
			this.setLiveness(true,7,18);
			this.setLiveness(true,8,15);
			this.setLiveness(true,8,16);


		}
	}

	public void glider() {
		clear();
		if (this.getRows() < 10 || this.getColumns() < 10) {
			System.out.println("Grid is too small for premade pattern Four Blinkers. " +
					"Conway must be at least 10x10");
		}
		else {

			this.setLiveness(true,1,1);
			this.setLiveness(true,1,3);
			this.setLiveness(true,2,2);
			this.setLiveness(true,2,3);
			this.setLiveness(true,3,2);

		}
	}

	public void yourDesignOne() {

	}

	public void yourDesignTwo() {

	}


	public void logAndCapture() {

	}

}