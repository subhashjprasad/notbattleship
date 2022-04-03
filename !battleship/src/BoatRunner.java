public class BoatRunner extends Boat{
    public BoatRunner(int team, Coordinates location, int direction, int health, int strength, int vision) {
        super(team, location, direction, health, strength, vision);
    }
    
    public String getID() {
        return "C";
    }
    
    public String act(int[] choices, World world){
        return "Not implemented in Part A";
    }
    
    public String getActions(){
        return "Not implemented in Part A";
    }
    
    public static void main(String[] args) {
        Coordinates c = new Coordinates(2, 3);
        Coordinates d = new Coordinates();
        if (d.getX() == 0 && d.getY() == 0) System.out.println("Coordinates default to 0");
        
        World w = new World(9, 9); //should default to minimum of x = 4
        if (w.getHeight() == 5)
            System.out.println("World height is correct");
        if (!w.isLocationValid(new Coordinates(2,6)))
            System.out.println("Marks an incorrect location");
        BoatRunner a = new BoatRunner(1, new Coordinates(0,0), 0, 9, 5, 6);
        if (w.setOccupant(a, new Coordinates(0,0)))
            System.out.println("Set a boat at (0,0)");
        Coordinates e = w.getAdjacentLocation(new Coordinates(0,0), w.SOUTHEAST);
        
        BoatRunner[] barray = new BoatRunner[1];
        barray[0] = new BoatRunner(1, new Coordinates(4,6), 2, 9, 5, 3);
        barray[1] = new BoatRunner(1, new Coordinates(2,2), 2, 9, 5, 3);
        w.setOccupant(barray[0], new Coordinates(4,6));
        w.setOccupant(barray[1], new Coordinates(2,2));
        String map1 = w.drawTeamMap(barray, 2);
        System.out.println(map1);
    }
}
