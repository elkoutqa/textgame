
public class Treasure extends Item {

	public static void main(String[] args) {
		
	}
	
	public static int xLocation = 0;
	public static int yLocation = 0;
	public static String typeOf = "";
	
	public Treasure(int xTreasureLocation, int yTreasureLocation, String typeOfTreasure) {

		super(xLocation, yLocation, typeOf);
		
		xLocation = xTreasureLocation;
		yLocation = yTreasureLocation;
		
		typeOf = typeOfTreasure;
	}
	
	public int getXLocation() {
		return xLocation;
	}
	
	public int getYLocation() {
		return yLocation;
	}
	
	public String getTypeOf() {
		return typeOf;
	}

}
