class Solution {
    public int maxProfit(int[] prices) {
        int[] dpLR = new int[prices.length];
        int[] dpRL = new int[prices.length];
        int min = prices[0];
        for(int i = 0; i < prices.length; ++i) {
            min = min > prices[i] ? prices[i] : min;
            if(i == 0) continue;
            if(dpLR[i - 1] < prices[i] - min) {
                dpLR[i] = prices[i] - min;
            }
            else {
                dpLR[i] = dpLR[i - 1];
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i = prices.length - 1; i >= 0; --i) {
            max = prices[i] > max ? prices[i] : max;
            if(i == prices.length - 1) continue;
            if(dpRL[i + 1] < max - prices[i]) {
                dpRL[i] = max - prices[i];
            }
            else {
                dpRL[i] = dpRL[i + 1];
            }
        }
        int res = 0;
        for(int i = 0; i < prices.length; ++i) {
            res = Math.max(res, dpLR[i] + dpRL[i]);
        }
        return res;
    }
}


// 3 3 5 2 1 7

// 0 0 2 2 2 6

// 6 6 6 6 6 0
    
// 1 2 3 4 5

// 0 1 2 3 4

// 4 3 2 1 0