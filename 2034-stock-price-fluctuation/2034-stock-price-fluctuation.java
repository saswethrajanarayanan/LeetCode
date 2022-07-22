class StockPrice {
    HashMap<Integer, Integer> timestamps;
    TreeMap<Integer, Integer> stocks;
    int latestTime;
    public StockPrice() {
        this.timestamps = new HashMap<>();
        this.stocks = new TreeMap<>();
        this.latestTime = 0;
    }
    
    public void update(int timestamp, int price) {
        if(timestamps.containsKey(timestamp)) { // both in the timestamp HM and stocks TM
            int currentPrice = timestamps.get(timestamp);
            timestamps.put(timestamp, price);
            if(stocks.get(currentPrice) == 1) {
                stocks.remove(currentPrice);
            }
            else {
                stocks.put(currentPrice, stocks.get(currentPrice) - 1);
            }
            stocks.put(price, stocks.getOrDefault(price, 0) + 1);
        }
        else {
            stocks.put(price, stocks.getOrDefault(price, 0) + 1);
            timestamps.put(timestamp, price);
        }
        latestTime = Math.max(latestTime, timestamp);
    }
    
    public int current() {
        return timestamps.get(latestTime);
    }
    
    public int maximum() {
        return stocks.lastKey();
    }
    
    public int minimum() {
        return stocks.firstKey();
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 1. Keep track of timestamps and the corresponding stockPrice. - HashMap<timestamp, stock>
 2. Keep track of max and min stockPrices along with the number of occurences of that price.
  - TreeMap<stock, number of its occurences>
 */