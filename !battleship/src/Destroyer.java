
public class Destroyer extends Boat implements Attacker{
	Destroyer(int t, Coordinates c, int d) {
		super(t, c, d, 2, 2, 1);
	}
	
	String getID() {
		return "D" + super.getTeam();
	}
	
	String getActions() {
		String res = "Choose any of the following actions for the Destroyer:\n1. Move\n2. Turn left\n3. Turn right\n4. Attack";
		return "\n" + res;
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
			} else if (arr[i] == 4) {
				res += attack(w);
			}
		}
		return "\n" + res;
	}
	
	public String attack(World w) {
		switch (super.getDirection()) {
			case 0: for (int i = 1; i <= super.getVision(); i++) {
				Coordinates cor = new Coordinates(super.getLocation().getX(), super.getLocation().getY() - i);
				if (w.isLocationOccupied(cor)) {
					return "\n" + w.getOccupant(cor).takeHit(getStrength(), w);
				}
			} return "\n" + "There are no boats in range currently\n";
			case 1: for (int i = 1; i <= super.getVision(); i++) {
				Coordinates cor = new Coordinates(super.getLocation().getX() + i, super.getLocation().getY() - i);
				if (w.isLocationOccupied(cor)) {
					return "\n" + w.getOccupant(cor).takeHit(getStrength(), w);
				}
			} return "\n" + "There are no boats in range currently\n";
			case 2: for (int i = 1; i <= super.getVision(); i++) {
				Coordinates cor = new Coordinates(super.getLocation().getX() + i, super.getLocation().getY());
				if (w.isLocationOccupied(cor)) {
					return "\n" + w.getOccupant(cor).takeHit(getStrength(), w);
				}
			} return "\n" + "There are no boats in range currently\n";
			case 3: for (int i = 1; i <= super.getVision(); i++) {
				Coordinates cor = new Coordinates(super.getLocation().getX() + i, super.getLocation().getY() + i);
				if (w.isLocationOccupied(cor)) {
					return "\n" + w.getOccupant(cor).takeHit(getStrength(), w);
				}
			} return "\n" + "There are no boats in range currently\n";
			case 4: for (int i = 1; i <= super.getVision(); i++) {
				Coordinates cor = new Coordinates(super.getLocation().getX(), super.getLocation().getY() + i);
				if (w.isLocationOccupied(cor)) {
					return "\n" + w.getOccupant(cor).takeHit(getStrength(), w);
				}
			} return "\n" + "There are no boats in range currently\n";
			case 5: for (int i = 1; i <= super.getVision(); i++) {
				Coordinates cor = new Coordinates(super.getLocation().getX() - i, super.getLocation().getY() + i);
				if (w.isLocationOccupied(cor)) {
					return "\n" + w.getOccupant(cor).takeHit(getStrength(), w);
				}
			} return "\n" + "There are no boats in range currently\n";
			case 6: for (int i = 1; i <= super.getVision(); i++) {
				Coordinates cor = new Coordinates(super.getLocation().getX() - i, super.getLocation().getY());
				if (w.isLocationOccupied(cor)) {
					return "\n" + w.getOccupant(cor).takeHit(getStrength(), w);
				}
			} return "\n" + "There are no boats in range currently\n";
			case 7: for (int i = 1; i <= super.getVision(); i++) {
				Coordinates cor = new Coordinates(super.getLocation().getX() - i, super.getLocation().getY() - i);
				if (w.isLocationOccupied(cor)) {
					return "\n" + w.getOccupant(cor).takeHit(getStrength(), w);
				}
			} return "\n" + "There are no boats in range currently\n";
		} return "uh oh";
	}
	
	String takeHit(int s, World w) {
		if (Math.random() * 2 == 0) {
			return "\n" + super.takeHit(s, w);
		} else {
			return "\n" + getID() + " avoids the attack!";
		}
	}
}
