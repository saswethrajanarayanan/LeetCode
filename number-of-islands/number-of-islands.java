class Solution {
    public int numIslands(char[][] grid) {
        if(grid.length == 0) return 0;
        int islands = 0;
        for(int i = 0; i < grid.length; ++i) {
            for(int j = 0; j < grid[i].length; ++j) {
                if(grid[i][j] == '1') {
                    islands += dfs(grid, i, j);
                }
            }
        }
        return islands;
    }
    private int dfs(char[][] grids, int i, int j) {
        if(i < 0 || i >= grids.length || j < 0 || j >= grids[i].length || grids[i][j] == '0') {
            return 0;
        }
        grids[i][j] = '0';
        dfs(grids, i + 1, j);
        dfs(grids, i - 1, j);
        dfs(grids, i, j + 1);
        dfs(grids, i, j - 1);
        return 1;
    }
}
