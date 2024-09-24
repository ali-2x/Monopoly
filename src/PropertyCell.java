import java.util.Scanner;

public class PropertyCell extends Cell {
    protected int baseCost;
    protected Player owner = null;
    int house = 0;

    /**
     * Return the owner of the property
     * @return owner
     */
    public Player getOwner() { return owner; }
    public PropertyCell(String name, int baseCost) {
        super(name);
        this.baseCost = baseCost;
    }
    public int getCost() { return baseCost; }
    public int getHouse() { return house; }


    @Override
    public String toString() {
        if (owner == null)
            return name + " owned by - : " + getCost();
        else {
            if (house == 0)
                return name + " owned by " + owner.getName() + " : " + getCost();
            else
                return name + " owned by " + owner.getName() + " : " + getCost() + " House: " + house;
        }
    }

    /**
     * Return the rent charged against this player. The formula for an ordinary cell is
     * baseCost * (1 + house * 0.5) rounding the nearest integer.
     *
     * @param p - The player who is charged. p is irrelevant in this case.
     * @return The rent.
     */
    public int getRent(Player p) {
        if (p == owner || owner == null)
            return 0;
        return (int)(baseCost * (1 + house * 0.5));
    }

    protected void buy(Player p) {
        System.out.printf("Do you want to buy this for $%d? (y/n): ", baseCost);
        Scanner scanner = new Scanner(System.in);

        if (scanner.next().equals("y")) {
            if (p.getMoney() >= baseCost) {
                p.charge(baseCost);
                owner = p;
                System.out.println("You have bought this land!");
            } else {
                System.out.println("Sorry you don't have enough money");
            }
        }
    }

    /**
     * Building cost = base cost / 5;
     */
    protected void build() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Do you want to build a house for this land for $%d? (y/n)", baseCost / 5); //pay one-fifth for building house
        if (scanner.next().equals("y")) {
            if (owner.getMoney() >= baseCost / 5) {
                owner.charge(baseCost / 5);
                house++;
                System.out.println("You have bought this land!");
            } else {
                System.out.println("Sorry you don't have enough money");
            }
        }
    }

    @Override
    public void event(Player p, Cell[] cells) {
        System.out.println("You have landed on " + name + "!");
        Scanner scanner = new Scanner(System.in);
        if (owner == null) {
            //prompt player to buy
            buy(p);
        } else if (owner == p) {
            //prompt player to build house
            build();
        } else {
            if (owner.isInPark()) {
                System.out.println(owner.getName() + " is in the Park. Free parking.");
                return;
            }
            int charge = getRent(p);
            p.charge(charge);
            owner.charge(-charge);
            System.out.printf("%s have paid %s $%d\n", p.getName(), owner.getName(), charge);
        }
    }

}
