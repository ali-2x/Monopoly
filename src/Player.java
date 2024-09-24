import java.util.concurrent.ThreadLocalRandom;

public class Player {
    private final String name;
    private int money;
    private int position;
    private int lastMove;
    private boolean inPark;
    private boolean inJail;
    public Player(String name) {
        this.name = name;
        money = 10000;
        position = 0;
        inPark = false;
        inJail = false;
    }

    public void roll() {
        if (inJail) {
            System.out.println(name + ", sorry you are in Jail. Skip one round.");
            inJail = false;
        } else {
            System.out.println(name + ", this is your turn. We roll for you");
            int step = ThreadLocalRandom.current().nextInt(1, 7);
            System.out.println("It is..." + step);

            if (position + step >= Gameboard.CELL_SIZE + Gameboard.HOME_POSITON) {
                money += 2000;
                position = position + step - Gameboard.CELL_SIZE;
            } else
                position = (position + step);
            lastMove = step;
            if (inPark)
                inPark = false; //get out from park.
        }
    }
    public boolean isInPark() { return inPark; }
    public void setInPark(boolean inPark) { this.inPark = inPark; }
    public boolean isInJail() { return inJail; }
    public void putToJail() {
        inJail = true;
        position = Gameboard.JAIL_POSITION;
    }

    public int getLastMove() { return lastMove; }
    public int getMoney() { return money; }
    public String getName() { return name; }
    public int getPosition() { return position; }
    public void charge(int money) { this.money -= money; }
}
