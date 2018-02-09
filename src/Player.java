import java.util.ArrayList;

public class Player {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Player p1 = new Player();
		Player p2 = new Player();
		
		System.out.println("Player Location: ("+p1.xLocation+","+p1.yLocation+")");
		
		//moveInDirection("north");
		
	}
	
	public static int xLocation = 0;
	public static int yLocation = 0;
	public static ArrayList<String> inventory = new ArrayList<>();
	
	public Player() {
		
	}
	
	public int getXLocation() {
		return xLocation;
	}
	
	public int getYLocation() {
		return yLocation;
	}
	
	public ArrayList<String> getInventory() {
		return inventory;
	}

	public static void location() {
		System.out.println("Player Location: ("+xLocation+","+yLocation+")");
	}
	
	
	public static void movePlayer(int xMovement, int yMovement) {
		xLocation = xLocation + xMovement;
		yLocation = yLocation + yMovement;
		
		//System.out.println("You have moved to: ("+xLocation+","+yLocation+")");
	}
	
	public static void moveInDirection(String direction) {
		
		if (direction.equals("north")) {
			movePlayer(0,1);
		} else if (direction.equals("east")) {
			movePlayer(1,0);
		} else if (direction.equals("south")) {
			movePlayer(0,-1);
		} else if (direction.equals("west")) {
			movePlayer(-1,0);
		} else {
			System.out.println("You can only move north, east, south, or west.");
		}
		
	}
	
	
	
	
}
