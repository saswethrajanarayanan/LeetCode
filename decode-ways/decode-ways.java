class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for(int i = 2; i <= s.length(); ++i) {
            int currentDigit = Integer.parseInt(s.substring(i - 1, i));
            int combinedDigits = Integer.parseInt(s.substring(i - 2, i));
            if(currentDigit >= 1) {
                dp[i] += dp[i - 1];
            }
            if(combinedDigits >= 10 && combinedDigits <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[s.length()];
    }
}