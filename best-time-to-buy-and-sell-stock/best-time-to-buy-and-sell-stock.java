class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int max = 0;
        HashSet<Integer> bPrices = new HashSet();
        for(int i = 0; i < prices.length; ++i) {
            int buyingPrice = prices[i];
            max = 0;
            if(bPrices.contains(buyingPrice)) {
                continue;
            }
            bPrices.add(buyingPrice);
            for(int j = i + 1; j < prices.length; ++j) {
                max = Math.max(prices[j], max);
            }
            if(max > buyingPrice) {
                profit = Math.max(max - buyingPrice, profit);
            }
        }
        return profit;
    }
}