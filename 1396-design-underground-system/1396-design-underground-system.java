class UndergroundSystem {
    HashMap<Integer, Pair<String, Integer>> checkIns;
    HashMap<Pair<String, String>, List<Integer>> travelTimes;
    public UndergroundSystem() {
        this.checkIns = new HashMap<>();
        this.travelTimes = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        Pair<String, Integer> pair = new Pair<>(stationName, t);
        checkIns.put(id, pair);
    }
    
    public void checkOut(int id, String stationName, int t) {
        if(!checkIns.containsKey(id)) {
            return;
        }
        Pair<String, Integer> pair = checkIns.get(id);
        int startTime = pair.getValue();
        int travelTime = t - startTime;
        String startStation = pair.getKey();
        Pair<String, String> stations = new Pair<>(startStation, stationName);
        if(travelTimes.containsKey(stations)) {
            List<Integer> list = travelTimes.get(stations);
            list.add(travelTime);
            travelTimes.put(stations, list);
        }
        else {
            List<Integer> list = new ArrayList<>();
            list.add(travelTime);
            travelTimes.put(stations, list);
        }
    }
    
    public double getAverageTime(String startStation, String endStation) {
        double average = 0;
        Pair<String, String> pair = new Pair<>(startStation, endStation);
        if(!travelTimes.containsKey(pair)) {
            return average;
        }
        List<Integer> list = travelTimes.get(pair);
        double sum = 0;
        for(int value : list) {
            sum += (double) (value);
        }
        return (sum / (double)(list.size()));
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */