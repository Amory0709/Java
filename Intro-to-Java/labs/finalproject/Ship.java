package finalproject;

import java.util.Arrays;

/**
 * @author Mariah Yelenick and Adam Kern
 * @version 11/18/18
 */
public class Ship{
	
	public int topLX, topLY, length;
	public boolean isH;
	public boolean [] hitOrNot;
	/**
	 * Create an instance of the ship class, recording all necessary information into
	 * any instance variables you choose to create
	 * 
	 * @param topLeftX the x coordinate of the ship's uppermost, leftmost space
	 * @param topLeftY the y coordinate of the ship's uppermost, leftmost space
	 * @param length the number of spaces the ship occupies
	 * @param isHorizontal if true, the ship is placed horizontally, else the ship is placed vertically
	 */
	public Ship(int topLeftX, int topLeftY, int length, boolean isHorizontal) {
		this.topLX = topLeftX;
		this.topLY = topLeftY;
		this.length = length;
		this.isH = isHorizontal;
		this.hitOrNot = new boolean [this.length];
		for(int i = 0; i < this.hitOrNot.length; ++i) {
			this.hitOrNot[i] = false;
		}
	}
	
	/**
	 * Check if the ship has been sunk
	 * This should only be true if the ship was hit in all the spaces it occupies
	 * 
	 * @return true if the ship has been sunk
	 */
	public boolean isSunk() {
		boolean sink = true;
			for(int i = 0; i < this.hitOrNot.length;++i) {
				sink = sink && this.hitOrNot[i];
			}
			return sink;
		
	}
	
	/**
	 * Check if the ship occupies a space at (x, y)
	 * Note: Be sure to update the hits array so that you can check if the ship is sunk!
	 * 
	 * @param x the x coordinate to shoot at
	 * @param y the y coordinate to shoot at
	 * @return true if this ship occupies that spot (hit), false otherwise (miss)
	 */
	public boolean isHit(int x, int y) {
		//horizontal boat
		if(this.isH) {
			if(x >= this.topLX && x <= (this.topLX+this.length-1) && y == this.topLY) {
				this.hitOrNot[x-this.topLX] = true;
				return true;
			}else {
				return false;
			}
		}
		//vertical boat
		else {
			if(y>=this.topLY && y<= (this.topLY + this.length-1) && x == this.topLX){
				this.hitOrNot[y-this.topLY] = true;
				return true;
			}else {
				return false;
			}
		}
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(hitOrNot);
		result = prime * result + (isH ? 1231 : 1237);
		result = prime * result + length;
		result = prime * result + topLX;
		result = prime * result + topLY;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ship other = (Ship) obj;
		if (!Arrays.equals(hitOrNot, other.hitOrNot))
			return false;
		if (isH != other.isH)
			return false;
		if (length != other.length)
			return false;
		if (topLX != other.topLX)
			return false;
		if (topLY != other.topLY)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Ship [topLX=" + topLX + ", topLY=" + topLY + ", length=" + length + ", isH=" + isH + "]";
	}
	
	
	
}
