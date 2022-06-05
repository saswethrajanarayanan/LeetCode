class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days.length + 1];
        dp[days.length] = 0;
        for(int i = days.length - 1; i >= 0; --i) {
            int d7 = i;
            int d30 = i;
            while(d7 < days.length && days[d7] < days[i] + 7) d7++;
            while(d30 < days.length && days[d30] < days[i] + 30) d30++;
            dp[i] = Math.min(costs[0] + dp[i + 1], Math.min(costs[1] + dp[d7], costs[2] + dp[d30]));
        }
        return dp[0];
    }
}