public class ParkCell extends FunctionCell {

    public ParkCell() {
        super("Park");
    }

    @Override
    public String toString() {
        return "Park";
    }

    @Override
    public void event(Player p, Cell[] cells) {
        //call the setInPark method in player class to place the player in park.
        p.setInPark(true);                                         
        System.out.println(p.getName() + " is in the park");
    }
}

