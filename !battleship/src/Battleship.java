
public class Battleship extends Boat implements Attacker{
	Battleship(int t, Coordinates c, int d) {
		super(t, c, d, 4, 3, 1);
	}
	
	String getID() {
		return "B" + super.getTeam();
	}
	
	String getActions() {
		String res = "Choose any of the following actions for the Battleship:\n1. Move\n2. Turn left\n3. Turn right\n4. Attack";
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
		switch (super.getDirection()) {
			case 0: for (int i = 1; i <= super.getVision(); i++) {
				Coordinates cor = new Coordinates(super.getLocation().getX(), super.getLocation().getY() - i);
				if (w.isLocationOccupied(cor)) {
					return "\n" + "Fire cannons!\n" + w.getOccupant(cor).takeHit(getStrength(), w) + "\n" + w.getOccupant(cor).takeHit(getStrength(), w);
				}
			} return "\n" + "There are no boats in range currently.";
			case 1: for (int i = 1; i <= super.getVision(); i++) {
				Coordinates cor = new Coordinates(super.getLocation().getX() + i, super.getLocation().getY() - i);
				if (w.isLocationOccupied(cor)) {
					return "\n" + "Fire cannons!\n" + w.getOccupant(cor).takeHit(getStrength(), w) + "\n" + w.getOccupant(cor).takeHit(getStrength(), w);
				}
			} return "\n" + "There are no boats in range currently.";
			case 2: for (int i = 1; i <= super.getVision(); i++) {
				Coordinates cor = new Coordinates(super.getLocation().getX() + i, super.getLocation().getY());
				if (w.isLocationOccupied(cor)) {
					return "\n" + "Fire cannons!\n" + w.getOccupant(cor).takeHit(getStrength(), w) + "\n" + w.getOccupant(cor).takeHit(getStrength(), w);
				}
			} return "\n" + "There are no boats in range currently.";
			case 3: for (int i = 1; i <= super.getVision(); i++) {
				Coordinates cor = new Coordinates(super.getLocation().getX() + i, super.getLocation().getY() + i);
				if (w.isLocationOccupied(cor)) {
					return "\n" + "Fire cannons!\n" + w.getOccupant(cor).takeHit(getStrength(), w) + "\n" + w.getOccupant(cor).takeHit(getStrength(), w);
				}
			} return "\n" + "There are no boats in range currently.";
			case 4: for (int i = 1; i <= super.getVision(); i++) {
				Coordinates cor = new Coordinates(super.getLocation().getX(), super.getLocation().getY() + i);
				if (w.isLocationOccupied(cor)) {
					return "\n" + "Fire cannons!\n" + w.getOccupant(cor).takeHit(getStrength(), w) + "\n" + w.getOccupant(cor).takeHit(getStrength(), w);
				}
			} return "\n" + "There are no boats in range currently.";
			case 5: for (int i = 1; i <= super.getVision(); i++) {
				Coordinates cor = new Coordinates(super.getLocation().getX() - i, super.getLocation().getY() + i);
				if (w.isLocationOccupied(cor)) {
					return "\n" + "Fire cannons!\n" + w.getOccupant(cor).takeHit(getStrength(), w) + "\n" + w.getOccupant(cor).takeHit(getStrength(), w);
				}
			} return "\n" + "There are no boats in range currently.";
			case 6: for (int i = 1; i <= super.getVision(); i++) {
				Coordinates cor = new Coordinates(super.getLocation().getX() - i, super.getLocation().getY());
				if (w.isLocationOccupied(cor)) {
					return "\n" + "Fire cannons!\n" + w.getOccupant(cor).takeHit(getStrength(), w) + "\n" + w.getOccupant(cor).takeHit(getStrength(), w);
				}
			} return "\n" + "There are no boats in range currently.";
			case 7: for (int i = 1; i <= super.getVision(); i++) {
				Coordinates cor = new Coordinates(super.getLocation().getX() - i, super.getLocation().getY() - i);
				if (w.isLocationOccupied(cor)) {
					return "\n" + "Fire cannons!\n" + w.getOccupant(cor).takeHit(getStrength(), w) + "\n" + w.getOccupant(cor).takeHit(getStrength(), w);
				}
			} return "\n" + "There are no boats in range currently.";
		} return "uh oh";
	}

}
