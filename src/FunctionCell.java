class FunctionCell extends Cell {
    public FunctionCell(String name) {
        super(name);
    }
    public void event(Player p, Cell[] cells) {
        System.out.println("You have arrived: " + name);
    }
}

class ParkCell extends FunctionCell {
    public ParkCell() {
        super("Park");
    }
    @Override
    public void event(Player p, Cell[] cells) {
        System.out.println(p.getName() + " is in the park");
        p.setInPark(true);
    }
}

class GotoJailCell extends FunctionCell {
    public GotoJailCell() {
        super("Go to Jail");
    }

    @Override
    public void event(Player p, Cell[] cells) {
        System.out.println(p.getName() + " go to Jail!");
        p.putToJail();
    }
}

