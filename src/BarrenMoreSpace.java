import java.lang.Math;
import java.util.ArrayList;
import java.util.Scanner;

public class BarrenMoreSpace {

	static ArrayList<Treasure> treasureDatabase = new ArrayList<>();
	static ArrayList<Item> itemDatabase = new ArrayList<>();
	static Item watch = new Item(0,1,"strange watch");
	
	
	public static void main(String[] args) {
		
		Player p1 = new Player();
		
	
		Treasure gold = new Treasure(2,2,"gold");
		Treasure vodka = new Treasure(2,2,"vodka");
		
		itemDatabase.add(watch);
		treasureDatabase.add(gold);
		treasureDatabase.add(vodka);
		
		runGame(p1, watch, gold);
		
	}
	
	public static void runGame(Player player,Item item, Treasure treasure) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Type 'help' for inputs.\n");
		System.out.println("You awaken to find yourself in a barren moor...");
		
		
		
		while (treasureDatabase.size() > 0) {		
			
			String input = scanner.nextLine();
			
			if (input.equals("look")) {
				
				lookAround(player, item);
				
			} else if (input.equals("help")) {
				
				help();
				
			} else if (input.equals("inventory")) {
				
				inventory(player);
				
			} else {
				
				player.moveInDirection(input);
				findItem(player);
				
				
				findTreasure(player);
				
				
				if (player.getInventory().contains("strange watch")) {
					nearestTreasure(player);
				}
				
				
				
			}
		}
		
		scanner.close();
		System.out.println("\nYou found all the treasure! You win!");
	}
	
	public static void help() {
		
		System.out.println("Inputs:\n");
		System.out.println("'look'\t\t- take in your surroundings");
		System.out.println("'inventory'\t- view your inventory");
		System.out.println("'north'\t\t- move north");
		System.out.println("'east'\t\t- move east");
		System.out.println("'south'\t\t- move south");
		System.out.println("'west'\t\t- move west");
		
	}
	
	public static void lookAround(Player player, Item item) {
		
		int xLocationPlayer = player.getXLocation();
		int yLocationPlayer = player.getYLocation();		
		
		int xLocationWatch = item.getXLocation();
		int yLocationWatch = item.getYLocation();
		
		
		if (xLocationPlayer == 0 && yLocationPlayer == 0) {
		

			
		System.out.println("Grey foggy clouds float oppressively close to you, reflected in the murky grey water which reaches up your shins.\n"
				+ "Some black plants barely poke of out of the shallow water.");
		} else if (player.getInventory().contains("strange watch")) {
			
			System.out.println("You can't see much in the darkness, maybe the strange watch can light the way.");
			nearestTreasure(player);
			
		} else if (xLocationPlayer <= (xLocationWatch + 3) && xLocationPlayer >= (xLocationWatch - 3)) {	
				
			if (yLocationPlayer == yLocationWatch) {
				System.out.println("You feel a strange sensation on your wrist, something nearby is calling for it.");
			} else if (yLocationPlayer < yLocationWatch) {
				System.out.println("You see something small glimmer north.");
			} else if (yLocationPlayer > yLocationWatch) {
				System.out.println("You see something small glimmer south.");
			}
			
		} else if (xLocationPlayer > (xLocationWatch + 3)) {

			if (yLocationPlayer == yLocationWatch) {
				System.out.println("You see something small glimmer west.");
			} else if (yLocationPlayer < yLocationWatch) {
				System.out.println("You see something small glimmer north west.");
			} else if (yLocationPlayer > yLocationWatch) {
				System.out.println("You see something small glimmer south west.");
			}
		
		} else if (xLocationPlayer < (xLocationWatch - 3)) {
			
			if(yLocationPlayer == yLocationWatch) {
				System.out.println("You see something small glimmer east.");
			} else if (yLocationPlayer < yLocationWatch ) {
				System.out.println("You see something small glimmer north east.");
			} else if (yLocationPlayer > yLocationWatch) {
				System.out.println("You see something small glimmer south east.");
			}			
		}
		
	}
	
	public static void inventory(Player player) {
		
		System.out.println(player.getInventory());
	}
	
	public static double distanceBetween(Player player, Item item) {
		
		double distance = 0;
		
		distance = java.lang.Math.pow(java.lang.Math.pow(player.getXLocation() - item.getXLocation(),2)+java.lang.Math.pow(player.getYLocation() - item.getYLocation(),2),0.5);
		
		return distance;
	}
	
	public static void nearestTreasure(Player player) {
		
		double distance;
		double minDistance = 1000;

		
		for (Treasure treasure: treasureDatabase) {

			distance = java.lang.Math.pow(java.lang.Math.pow(player.getXLocation() - treasure.getXLocation(),2)+java.lang.Math.pow(player.getYLocation() - treasure.getYLocation(),2),0.5);

			if (distance <= minDistance) {
				minDistance = distance;
			}
		}
		
		if (treasureDatabase.size()>0) {
		System.out.printf("The strange watch reads %.2f m.\n",minDistance);
		}
		
	}
	
	public static boolean findItem(Player player) {
		
		for (Item item: itemDatabase) {
		
			if (distanceBetween(player, item) == 0){
			
				String typeOf = item.getTypeOf();
				
				System.out.printf("You find a %s!\n", typeOf);
				player.getInventory().add(typeOf);	
				itemDatabase.remove(item);
				
				return true;
			}
		}
		
		return false;
	}	
	
	public static boolean findTreasure(Player player) {
		
		for (Treasure treasure: treasureDatabase) {
		
			if (distanceBetween(player, treasure) == 0){
			
				String typeOf = treasure.getTypeOf();
				
				System.out.printf("You find treasure! %s!\n", typeOf);
				player.getInventory().add(typeOf);	
				treasureDatabase.remove(treasure);
				
				return true;
			}
		}
		
		return false;
	}
	
	
	
}
