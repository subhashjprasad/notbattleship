
public class Submarine extends ScoutBoat implements Attacker{
	private int numOfTorpedoes;
	
	Submarine(int t, Coordinates c, int d, int n) {
		super(t, c, d, 3, 2);
		numOfTorpedoes = n;
	}
	
	String getID() {
		return "S" + super.getTeam();
	}
	
	String getActions() {
		String res = "Choose any of the following actions for the Submarine:\n1. Move\n2. Turn left\n3. Turn right\n4. Submerge";
		if (numOfTorpedoes > 0) res += "\n5. Fire torpedoes";
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
				res += submerge(w);
			} else if (arr[i] == 5) {
				res += attack(w);
			}
		}
		return "\n" + res;
	}
	
	public String attack(World w) {
		if (numOfTorpedoes > 0) {
			switch (super.getDirection()) {
			case 0: for (int i = 1; i <= super.getVision(); i++) {
				Coordinates cor = new Coordinates(super.getLocation().getX(), super.getLocation().getY() - i);
				if (w.isLocationOccupied(cor)) {
					int st = (int)(Math.random() * w.getOccupant(cor).getHealth()) + 1;
					return "\n" + "Fire torpedoes!\n" + w.getOccupant(cor).takeHit(st, w);
				}
			} return "\n" + "There are no boats in range currently.";
			case 1: for (int i = 1; i <= super.getVision(); i++) {
				Coordinates cor = new Coordinates(super.getLocation().getX() + i, super.getLocation().getY() - i);
				if (w.isLocationOccupied(cor)) {
					int st = (int)(Math.random() * w.getOccupant(cor).getHealth()) + 1;
					return "\n" + "Fire torpedoes!\n" + w.getOccupant(cor).takeHit(st, w);
				}
			} return "\n" + "There are no boats in range currently.";
			case 2: for (int i = 1; i <= super.getVision(); i++) {
				Coordinates cor = new Coordinates(super.getLocation().getX() + i, super.getLocation().getY());
				if (w.isLocationOccupied(cor)) {
					int st = (int)(Math.random() * w.getOccupant(cor).getHealth()) + 1;
					return "\n" + "Fire torpedoes!\n" + w.getOccupant(cor).takeHit(st, w);
				}
			} return "\n" + "There are no boats in range currently.";
			case 3: for (int i = 1; i <= super.getVision(); i++) {
				Coordinates cor = new Coordinates(super.getLocation().getX() + i, super.getLocation().getY() + i);
				if (w.isLocationOccupied(cor)) {
					int st = (int)(Math.random() * w.getOccupant(cor).getHealth()) + 1;
					return "\n" + "Fire torpedoes!\n" + w.getOccupant(cor).takeHit(st, w);
				}
			} return "\n" + "There are no boats in range currently.";
			case 4: for (int i = 1; i <= super.getVision(); i++) {
				Coordinates cor = new Coordinates(super.getLocation().getX(), super.getLocation().getY() + i);
				if (w.isLocationOccupied(cor)) {
					int st = (int)(Math.random() * w.getOccupant(cor).getHealth()) + 1;
					return "\n" + "Fire torpedoes!\n" + w.getOccupant(cor).takeHit(st, w);
				}
			} return "\n" + "There are no boats in range currently.";
			case 5: for (int i = 1; i <= super.getVision(); i++) {
				Coordinates cor = new Coordinates(super.getLocation().getX() - i, super.getLocation().getY() + i);
				if (w.isLocationOccupied(cor)) {
					int st = (int)(Math.random() * w.getOccupant(cor).getHealth()) + 1;
					return "\n" + "Fire torpedoes!\n" + w.getOccupant(cor).takeHit(st, w);
				}
			} return "\n" + "There are no boats in range currently.";
			case 6: for (int i = 1; i <= super.getVision(); i++) {
				Coordinates cor = new Coordinates(super.getLocation().getX() - i, super.getLocation().getY());
				if (w.isLocationOccupied(cor)) {
					int st = (int)(Math.random() * w.getOccupant(cor).getHealth()) + 1;
					return "\n" + "Fire torpedoes!\n" + w.getOccupant(cor).takeHit(st, w);
				}
			} return "\n" + "There are no boats in range currently.";
			case 7: for (int i = 1; i <= super.getVision(); i++) {
				Coordinates cor = new Coordinates(super.getLocation().getX() - i, super.getLocation().getY() - i);
				if (w.isLocationOccupied(cor)) {
					int st = (int)(Math.random() * w.getOccupant(cor).getHealth()) + 1;
					return "\n" + "Fire torpedoes!\n" + w.getOccupant(cor).takeHit(st, w);
				}
			} return "\n" + "There are no boats in range currently.";
			}
		} return "\n" + getID() + " has no torpedoes remaining.";
	}
	
	String submerge (World w) {
		while (true) {
			int new_x = (int)(Math.random() * w.getWidth());
			int new_y = (int)(Math.random() * w.getHeight());
			if ((new_x > getLocation().getX() + 2 || new_x < getLocation().getX() - 2) && (new_y > getLocation().getY() + 2 || new_y < getLocation().getY() - 2)) {
				Coordinates n = new Coordinates(new_x, new_y);
				if (!w.isLocationOccupied(n)) {
					Coordinates old = getLocation();
					setLocation(n);
					w.setOccupant(this, n);
					w.setOccupant(null, old);
					return "\n" + getID() + " moves from " + old + " to " + n;
				}
			}
		}
	}
}
