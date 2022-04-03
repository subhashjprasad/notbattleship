
public class Coordinates {
	private int x;
	private int y;
	
	Coordinates() {
		x = 0;
		y = 0;
	}
	
	Coordinates(int x_val, int y_val) {
		x = x_val;
		y = y_val;
	}
	
	int getX() {
		return x;
	}
	
	int getY() {
		return y;
	}
	
	void setCoordinates(int x_val, int y_val) {
		x = x_val;
		y = y_val;
	}
	
	public String toString() {
		return "" + (char)(y + 65) + (x + 1);
	}
}
