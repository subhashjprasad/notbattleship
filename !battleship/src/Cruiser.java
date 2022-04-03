
public class Cruiser extends ScoutBoat{
	Cruiser(int t, Coordinates c, int d) {
		super(t, c, d, 3, 3);
	}
	
	String getID() {
		return "C" + super.getTeam();
	}
	
	String getActions() {
		return "\n" + "Choose any of the following actions for the Cruiser:\n1. Move\n2. Turn left\n3. Turn right";
	}
	
	String act(int arr[], World w) {
		String res = "";
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 1) {
				res += super.move(w);
			} else if (arr[i] == 2) {
				res += super.turn(-1);
			} else if (arr[i] == 3) {
				res += super.turn(1);
			}
		}
		return "\n" + res;
	}
}
