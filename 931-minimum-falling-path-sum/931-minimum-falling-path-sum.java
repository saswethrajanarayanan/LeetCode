class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int minSum = Integer.MAX_VALUE;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; ++i) {
            for(int j = 0; j < matrix[i].length; ++j) {
                if(i == 0) {
                    dp[i][j] = matrix[i][j];
                }
                if(i != 0 && j == 0) {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j], dp[i - 1][j + 1]);
                }
                if(i != 0 && j == matrix[i].length - 1) {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
                }
                else if(i != 0 && j != 0) {
                    dp[i][j] = matrix[i][j] + Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i - 1][j + 1]));
                }
            }
        }
        for(int val : dp[matrix.length - 1]) {
            minSum = Math.min(minSum, val);
        }
        return minSum;
    }
}