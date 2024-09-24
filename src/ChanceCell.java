import java.util.concurrent.ThreadLocalRandom;

/**
 * Got one of the following chances randomly:
 * 1. Roll again
 * 2. +1000
 * 3. -1000
 * 4. Move to Jail directly without getting the 2000.
 */
class ChanceCell extends FunctionCell {

    public ChanceCell(String name) {
        super(name);
    }

    @Override
    public void event(Player p, Cell[] cells) {
//        super.event(p, cells);
        switch (ThreadLocalRandom.current().nextInt(0,4)) {
            case 0:
                System.out.println(name + " result: Roll again!");
                p.roll();
                cells[p.getPosition()].event(p, cells);
                break;
            case 1:
                System.out.println(name + " result: Gain $1000!");
                p.charge(-1000);
                break;
            case 2:
                System.out.println(name + " result: Deduct $1000!");
                p.charge(1000);
                break;
            case 3:
                p.putToJail();
                System.out.println(name + " result: Go to Jail, now!");
                break;
        }
    }
}