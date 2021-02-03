class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int min = Integer.MAX_VALUE;
        int[][] dp = new int[matrix.length][matrix[0].length];
        if(matrix.length == 1) return matrix[0][0];
        
        for(int i = 0; i < matrix.length; ++i) {
            for(int j = 0; j < matrix[i].length; ++j) {
                dp[i][j] += matrix[i][j];
                if(i > 0) {
                    if(j == 0) {
                        dp[i][j] += Math.min(dp[i - 1][j], dp[i - 1][j + 1]);
                    }
                    else if(j == matrix[i].length - 1) {
                        dp[i][j] += Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
                    }
                    else {
                        dp[i][j] += Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i - 1][j + 1]));
                    }
                    if(i == matrix.length - 1) min = Math.min(min, dp[i][j]);
                }
            }
        }
        return min;
    }
}