class Solution {
    class State {
        int row;
        int col;
        int removals_left;
        int steps_taken;
        
        public State(int r, int c, int k, int sT) {
            this.row = r;
            this.col = c;
            this.removals_left = k;
            this.steps_taken = sT;
        }
    }
    public int shortestPath(int[][] grid, int k) {
        if(k == 0 && grid[0][0] == 1) {
            return -1;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        if(k >= (rows - 1) + (cols - 1)) {
            return (rows + cols -2);
        }
        Queue<State> queue = new ArrayDeque<>();
        queue.add(new State(0, 0, k, 0));
        HashSet<String> visited = new HashSet<>();
        int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        while(!queue.isEmpty()) {
            State state = queue.poll();
            if(state.row == rows - 1 && state.col == cols - 1) {
                return state.steps_taken;
            }
            for(int[] degFreedom : directions) {
                int new_row = state.row + degFreedom[0];
                int new_col = state.col + degFreedom[1];
                if(new_row >= 0 && new_row < rows && new_col >= 0 && new_col < cols) {
                    int removals = state.removals_left - grid[new_row][new_col];
                    if(removals >= 0 && !visited.contains(new_row + " " + new_col + " " + removals)) {
                    visited.add(new_row + " " + new_col + " " + removals);
                    queue.add(new State(new_row, new_col, removals, state.steps_taken + 1));
                }
              }
            }
        }
        return -1;
    }
}