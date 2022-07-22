class Solution {
    public boolean removeOnes(int[][] grid) {
        for(int i = 0; i < grid.length; ++i) {
            int zerothElement = Math.abs(grid[i][0] - grid[0][0]);
            for(int j = 0; j < grid[i].length; ++j) {
                int nonZeroElement = Math.abs(grid[i][j] - grid[0][j]);
                if(zerothElement != nonZeroElement) {
                    return false;
                }
            }
        }
        return true;
    }
}