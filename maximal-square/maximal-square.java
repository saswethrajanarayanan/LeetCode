class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix.length == 0) return 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        int result = 0;
        for(int row = 0; row < matrix.length; ++row) {
            for(int col = 0; col < matrix[row].length; ++col) {
                dp[row][col] += matrix[row][col] - '0';
                if(matrix[row][col] == '1') {
                    if(row > 0 && col > 0) {
                        dp[row][col] += Math.min(dp[row - 1][col - 1], (Math.min(dp[row - 1][col], dp[row][col - 1])));
                    }
                }
                result = Math.max(result, dp[row][col]);
            }
        }
        return result * result;
    }
}