
public class Item {

	public static void main(String[] args) {
		
	}
	
	public int xLocation = 0;
	public int yLocation = 0;
	public String typeOf = "idiot";
	
	public Item(int xItemLocation, int yItemLocation, String typeOfItem) {
		
		xLocation = xItemLocation;
		yLocation = yItemLocation;
		
		typeOf = typeOfItem;
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
