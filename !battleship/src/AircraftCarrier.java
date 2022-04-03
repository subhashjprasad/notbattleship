
public class AircraftCarrier extends Boat implements Attacker{
	private boolean hasPlanes = true;
	private int successRate = 1;
	
	AircraftCarrier(int t, Coordinates c, int d) {
		super(t, c, d, 5, 1, 1);
	}
	
	String getID() {
		return "A" + super.getTeam();
	}
	
	String getActions() {
		String res = "Choose any of the following actions for the Aircraft Carrier:\n1. Move\n2. Turn left\n3. Turn right";
		if (hasPlanes) res += "\n4. Launch planes";
		return "\n" + res;
	}
	
	String act(int arr[], World w) {
		String res = "";
		for (int i = 0; i < 1; i++) {
			if (arr[i] == 1) {
				res += super.move(w);
			} else if (arr[i] == 2) {
				res += super.turn(-1);
			} else if (arr[i] == 3) {
				res += super.turn(1);
			} else if (arr[i] == 4) {
				res += attack(w);
			}
		}
		return "\n" + res;
	}
	
	public String attack(World w) {
		String res = "";
		if (hasPlanes) {
			int oldsucc = successRate;
			for (int i = getLocation().getX() - getVision(); i <= getLocation().getX() + getVision(); i++) {
				for (int j = getLocation().getY() - getVision(); j <= getLocation().getY() + getVision(); j++) {
					Coordinates c = new Coordinates(i, j);
					if (w.isLocationOccupied(c) && w.getOccupant(c) != this) {
						res += "Air raid! ";
						res += w.getOccupant(c).takeHit(getStrength(), w);
						successRate *= 0.8;
						if (Math.random() > successRate) {
							hasPlanes = false;
							res += "\nThe planes have been destroyed.";
							return "\n" + res;
						}
					}
				}
			}
			if (successRate == oldsucc) res += "\nThere are no boats in range currently.";
		} else res += "\n" + getID() + " has no planes remaining.";
		return "\n" + res;
	}
}
