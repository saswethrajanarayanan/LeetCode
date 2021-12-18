class Solution {
    Integer[][] dp;
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for(int val: stones) {
            sum += val;
        }
        int target = sum >> 1;
        dp = new Integer[stones.length][(sum >> 1) + 1];
        int maxSum = btrack(stones, target, 0, 0);
        return (sum - 2 * maxSum);
    }
    private int btrack(int[] stones, int target, int start, int currSum) {
        if(stones.length == start) {
            return currSum;
        }
        if(dp[start][currSum] != null) {
            return dp[start][currSum];
        }
        if(stones[start] + currSum > target) {
            dp[start][currSum] = btrack(stones, target, start + 1, currSum);
            return dp[start][currSum];
        }
        else {
            dp[start][currSum] = Math.max(btrack(stones, target, start + 1,                                                   stones[start] + currSum), btrack(stones,                                             target, start + 1, currSum));
            return dp[start][currSum];
        }
    }
}