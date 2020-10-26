package finalproject;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import cse131.ArgsProcessor;
import cse131.NotYetImplementedException;

public class HumanPlayer implements Player {
	
	private final ArgsProcessor ap; // Don't change this!
	private String name;
	private int width, height;
	private List <Ship> ships;
	private boolean [][] recordHit;
	private boolean [][] recordFire;
	private int [][] map;
	/**
	 * Creates an instance of the HumanPlayer class
	 * Note that we already dealt with taking in an ArgsProcessor object
	 * 		We know you've never seen this before, which is why it's given to you
	 * 		You can treat this ArgsProcessor (ap) throughout the HumanPlayer class
	 * 			like any other ArgsProcessor you've used in 131
	 * We leave the rest of the constructor to you
	 * 
	 * @param name the name of the player
	 * @param height the height of the board
	 * @param width the width of the board
	 * @param ap the ArgsProcessor object
	 */
	public HumanPlayer(String name, int height, int width, ArgsProcessor ap) {
		this.ap = ap;
		this.name = name;
		this.width = width;
		this.height = height;
		this.ships = new LinkedList<Ship>();
		this.recordHit = new boolean [width][height];
		this.recordFire = new boolean[width][height];
	}
	
	@Override
	public boolean addShip(Ship s) {
		//check if already exist, cross border and overlap
		if(this.isValidShipToAdd(s)) {
			return this.ships.add(s);	
		}else {
			return this.isValidShipToAdd(s);
		}
	}

	@Override
	public int[] getTargetLocation() {
		int x = -1;
		int y = -1;
		int [] result = new int [2]; 
		while((x < 0 || x > this.width-1) || (y < 0 || y > this.height-1) ){
			x = this.ap.nextInt("x coordinate of your goal");
			y = this.ap.nextInt("y coordinate of your goal");
		}
		result[0] = x;
		result[1] = y;
		return result;
	}

	@Override
	public void recordHitOrMiss(int x, int y, boolean isHit) {
		recordHit[x][y] = isHit;
	}

	@Override
	public Ship decideShipPlacement(int length) {
		int x = this.ap.nextInt("The top left x coordinate of your ship");
		int y = this.ap.nextInt("The top Left y coordinate of your ship");
		boolean hOrN = this.ap.nextBoolean("Do you want your ship to be horizontal? (Enter true or false)");
		Ship s = new Ship(x,y,length,hOrN);
		while(!this.isValidShipToAdd(s)) {
			x = this.ap.nextInt("The top left x coordinate of your ship");
			y = this.ap.nextInt("The top Left y coordinate of your ship");
			hOrN = this.ap.nextBoolean("Do you want your ship to be horizontal? (Enter true or false)");
			s = new Ship(x,y,length,hOrN);
		}
		return s;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public boolean respondToFire(int x, int y) {
		for(int i = 0; i < this.ships.size();++i) {
				if(this.ships.get(i).isHit(x, y)) {
					this.recordFire[x][y] = true;
//					this.recordHitOrMiss(x, y, true);
					return true;
				}
			}
//			this.recordHitOrMiss(x, y, false);
			return false;
		
	}

	@Override
	public int numShipsStillAfloat() {
		int afloat = 0;
		for(int i = 0; i < ships.size();++i) {
			if(!ships.get(i).isSunk()) {
				afloat = afloat + 1;
			}
		}
		return afloat;
	}

	@Override
	public boolean addRandomShip(int length) {
		int x = (int)(width * Math.random());
		int y = (int)(height * Math.random());
		boolean h;
		if(Math.random()<0.5) {
			 h = true;
		}else {
			 h = false;
		}
		Ship s = new Ship(x, y,length, h);
		while(!this.isValidShipToAdd(s)) {
			x = (int)(width * Math.random());
			y = (int)(height * Math.random());
			h = Math.random()>0.5?true:false;
			s = new Ship(x, y,length, h);
		}
		this.ships.add(s);
		return true;
	}

	@Override
	public boolean isValidShipToAdd(Ship s) {
		//Check if we already have this ship
		for(int i = 0;i < this.ships.size();++i) {
			if(s.equals(this.ships.get(i))) {
				return false;
			}
		}
		
		// cannot cross the border
		// cannot cross other ships
		// check the initial point of this boat
		if(s.topLX >= 0 && s.topLX <= (this.width-1) &&
		   s.topLY >= 0 && s.topLY <= (this.height-1)) {
			
			// check if this boat's whole body will cross the border
			// if this boat is hori
			if(s.isH) {
				if(s.topLX + s.length > this.width) {
					return false;
				}
				else {
					//check if it crosses other boats by loop with other boats
					for(int i = 0; i < ships.size();++i) {
						
						// if horizontal
						if(s.isH) {
							for(int j = s.topLX; j < s.topLX + s.length; ++j) {
								if(this.ships.get(i).isHit(j, s.topLY)) {
									return false;
								}
							}
						//if vertical
						}else {
							for(int j = s.topLY; j < s.topLY + s.length; ++j) {
								if(this.ships.get(i).isHit(s.topLX, j)) {
									return false;
								}
							}
						}
					}// end of loop boat
					return true;
				}
			// if this boat is vertical
			}else {
				if(s.topLY + s.length > this.height) {
					return false;
				}else {
					//check if it crosses other boats by loop with other boats
					for(int i = 0; i < ships.size();++i) {
						
						// if horizontal
						if(s.isH) {
							for(int j = s.topLX; j < s.topLX + s.length; ++j) {
								if(this.ships.get(i).isHit(j, s.topLY)) {
									return false;
								}
							}
						//if vertical
						}else {
							for(int j = s.topLY; j < s.topLY + s.length; ++j) {
								if(this.ships.get(i).isHit(s.topLX, j)) {
									return false;
								}
							}
						}
					}// end of loop boat
					return true;
				}
			}
			
		// cross the border
		}else {
			return false;
		}
	}
//	@Override
//	public boolean isValidShipToAdd(Ship s) {
//		int x=s.isH?1:0;
//		  int y=s.isH?0:1;
//		  if(s.length>(s.isH?this.width:this.height)) {return false;}
//		  for(int i=0;i < s.length;i++) {
//		   if(s.topLX+x*i<0||s.topLX+x*i>=this.width) {return false;}//width out of bound
//		   else if(s.topLY+y*i<0||s.topLY+y*i>=this.height) {return false;}//height out of bound
//		   else if(map[s.topLX+x*i][s.topLY+y*i]!=0) {return false;}//already occupied
//		    }
//		  return true;
//		 }
//	}
	@Override
	public void printRadar() {
//		for(int i = 0; i < this.height;++i) {
//			for(int j = 0; j < this.height;++j) {
//				if(this.respondToFire(j, i)) {
//					if(this.recordHitOrMiss(j, i, isHit);)
//				}
//			}
//		}
	}


}
