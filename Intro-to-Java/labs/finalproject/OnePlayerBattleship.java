package finalproject;

import cse131.ArgsProcessor;
import cse131.NotYetImplementedException;

public class OnePlayerBattleship implements Battleship {

	private ArgsProcessor ap;
	private Player p1;
	
	/**
	 * The main method that gets the starting parameters for a game,
	 * creates an instance of the OnePlayerBattleship class,
	 * and plays the game!
	 * @param args
	 */
	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		
		String name = ap.nextString("What is the player's name?");
		int length = ap.nextInt("What is the length of the board?");
		int width = ap.nextInt("What is the width of the board?");
		int numShips = ap.nextInt("How many ships should each player have?");
		boolean randomShips = ap.nextBoolean("Should the ships be placed randomly? Type true or false");
		Battleship bs = new OnePlayerBattleship(length, width, randomShips, numShips, name, ap);
		Player winner = bs.play();
		System.out.println(winner.getName() + " won!");
	}
	
	/**
	 * Create an instance of the OnePlayerBattleship class
	 * Create a player with the given name
	 * Place all ships, randomly or manually
	 * 
	 * NOTE: We've created the player for you, in order to deal with the ArgsProcessor that needs to be passed
	 * 
	 * @param width width of the board (# cols)
	 * @param height height of the board (# rows)
	 * @param randomShips whether or not the ships should be placed randomly
	 * @param playerName the name of the Player who will be playing the game
	 */
	
	public OnePlayerBattleship(int width, int height, boolean randomShips, int numShips, String playerName, ArgsProcessor ap) {
		p1 = new HumanPlayer(playerName, height, width, ap); // DON'T CHANGE THIS
		for(int i = 0; i < numShips; ++i) {
			p1.addRandomShip((int)(Math.min(height, width)*Math.random()));
		}
		
	}

	@Override
	public Player play() {
		return p1;
		
	}

	@Override
	public boolean turn(Player p) {
		this.p1.printRadar();
		int x = this.p1.getTargetLocation()[0];
		int y = this.p1.getTargetLocation()[1];
		this.p1.respondToFire(x,y);
		// is hit?
		//is Sink?
		 if (p1.numShipsStillAfloat() == 0){
			 return true;//game over
		}else{ 
			return false;
		}
	}
	
	/**
	 * We've implemented this for you since there's only one player, you can leave this alone!
	 */
	@Override
	public Player getPlayerOne() {
		return p1;
	}

	/**
	 * We've implemented this for you since there's only one player, you can leave this alone!
	 */
	@Override
	public Player getPlayerTwo() {
		return null;
	}

}
