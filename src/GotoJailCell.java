class GotoJailCell extends FunctionCell {

    public GotoJailCell() {
        super("Go to Jail");
    }

    @Override
    public String toString() {
        return "Go to Jail";
    }

    @Override
    public void event(Player p, Cell[] cells) {
        //call the putToJail method in player class to place the player in Jail
        p.putToJail();           
        System.out.println(p.getName() + " go to jail!");
    }
}
