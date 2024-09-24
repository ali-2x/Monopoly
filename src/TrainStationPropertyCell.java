public class TrainStationPropertyCell extends PropertyCell {
    public static final int TRAIN_STATION_COST = 500;

    public static final TrainStationPropertyCell[] TRAIN_STATION_ARRAY = {
            new TrainStationPropertyCell("Kowloon"),
            new TrainStationPropertyCell("Mongkok"),
            new TrainStationPropertyCell("Central"),
            new TrainStationPropertyCell("Shatin")
    };

    public TrainStationPropertyCell(String name) {
        super(name, TRAIN_STATION_COST);
    }

    /**
     * If the owner owns only one train station, the rent is 500
     * If the owner owns two of them, the rent is 1000
     * If the owner owns three of them, the rent is 2000
     * If the owner owns four of them, the rent is 4000
     *
     * @param p not be used.
     * @return Price
     */
    @Override
    public int getRent(Player p) {
        if (p == owner || owner == null)
            return 0;

        int count = 0;
        for (int i = 0; i < 4; i++)
            if (TRAIN_STATION_ARRAY[i].owner == owner)
                count++;
        switch (count) {
            case 1: return 500;
            case 2: return 1000;
            case 3: return 2000;
            case 4: return 4000;
        }
        return 0;//should not be possible
    }

    @Override
    protected void build() {
        //don't build
    }
}
