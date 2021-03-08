class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        
        if(obstacleGrid.length == 0) return 0;
        if(obstacleGrid[0][0] == 1) {
            dp[0][0] = 0;
        }
        else {
            dp[0][0] = 1;
        }
        
        for(int rows = 0; rows < obstacleGrid.length; ++rows) {
            for(int cols = 0; cols < obstacleGrid[rows].length; ++cols) {
                if(rows == 0 && cols == 0) continue;
                
                if(obstacleGrid[rows][cols] == 1) {
                    continue;
                }
                
                if(cols == 0 && rows != 0) {
                    if(obstacleGrid[rows - 1][cols] != 1) {
                        dp[rows][cols] += dp[rows - 1][cols];
                    }
                }
                if(rows == 0 && cols != 0) {
                    if(obstacleGrid[rows][cols - 1] != 1) {
                        dp[rows][cols] += dp[rows][cols - 1];
                    }
                }
                if(rows != 0 && cols != 0) {
                    if(obstacleGrid[rows - 1][cols] != 1) {
                        dp[rows][cols] += dp[rows - 1][cols];
                    }   
                    if(obstacleGrid[rows][cols - 1] != 1) {
                        dp[rows][cols] += dp[rows][cols - 1];
                    }
                }
            }
        }
        return dp[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }
}