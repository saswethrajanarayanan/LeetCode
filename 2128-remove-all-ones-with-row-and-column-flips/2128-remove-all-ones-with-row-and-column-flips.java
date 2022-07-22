class Solution {
    public boolean removeOnes(int[][] grid) {
        for(int i = 0; i < grid.length; ++i) {
            int[] row = grid[i];
            int zerothElement = Math.abs(row[0] - grid[0][0]);
            for(int j = 0; j < row.length; ++j) {
                int nonZeroElement = Math.abs(row[j] - grid[0][j]);
                if(zerothElement != nonZeroElement) {
                    return false;
                }
            }
        }
        return true;
    }
}