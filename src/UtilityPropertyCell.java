public class UtilityPropertyCell extends PropertyCell {
    public static final int UTILITY_PROPERTY_COST = 500;
    public static final UtilityPropertyCell LIBRARY_UTILITY_CELL = new UtilityPropertyCell("Library", UTILITY_PROPERTY_COST);
    public static final UtilityPropertyCell CANTEEN_UTILITY_CELL = new UtilityPropertyCell("Canteen", UTILITY_PROPERTY_COST);
    public UtilityPropertyCell(String name, int cost) {
        super(name, cost);
    }


    /**
     * The rent of UtilityPropertyCell is computed by the number of steps that the player rolled multiply by x
     * x = 100, if both property are owned by the same player
     * x = 10, if the owner of this property cell owns only one property cell.
     *
     * @param p the Player who steps on this utilityPropertyCell
     * @return the money charged.
     */
    @Override
    public int getRent(Player p) {
        if (p == owner || owner == null)
            return 0;
        int lastMove = p.getLastMove();
        if (LIBRARY_UTILITY_CELL.owner == CANTEEN_UTILITY_CELL.owner)
            return lastMove * 100;
        return lastMove * 10;
    }
    
    @Override
    protected void build() {
        //does not build
    }
}
