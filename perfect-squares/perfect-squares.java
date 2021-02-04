class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;             
        for(int i = 1; i <= n; ++i) {
            dp[i] = i;
            for(int j = i - 1; j > 0; --j) {
                if(j * j == i) {
                    dp[i] = 1;
                }
                dp[i] = Math.min(dp[i], dp[j] + dp[i - j]);
            }
        }
        return dp[n];
    }
}