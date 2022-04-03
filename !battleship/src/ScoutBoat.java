
public abstract class ScoutBoat extends Boat {
	
	ScoutBoat(int t, Coordinates l, int d, int h, int v) {
		super(t, l, d, h, 1, v);
	}
	
	String takeHit(int num, World w) {
		if ((int)(Math.random() * 4) == 0) {
			return super.takeHit(num, w);
		} else return "\n" + super.toString() + " has avoided the attack!";
	}
	
}
