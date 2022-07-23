class Solution {
    class State {
        int row;
        int col;
        int distance;
        
        public State(int row, int col, int distance) {
            this.row = row;
            this.col = col;
            this.distance = distance;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1) return -1;
        int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}, {-1, -1}, {1, 1}, {1, -1}, {-1, 1}};
        Queue<State> queue = new ArrayDeque<>();
        int rows = grid.length - 1;
        int cols = grid[0].length - 1;
        HashSet<String> visited = new HashSet<>();
        queue.add(new State(0, 0, 1));
        while(!queue.isEmpty()) {
            State state = queue.poll();
            int row = state.row;
            int col = state.col;
            int distance = state.distance;
            
            if(state.row == rows && state.col == cols) {
                return state.distance;
            }
            if(visited.contains(row + " " + col)) continue;
            for(int[] direction : directions) {
                int new_row = row + direction[0];
                int new_col = col + direction[1];
                
                if(new_row >= 0 && new_row <= rows && new_col >= 0 && new_col <= cols) {
                    if(grid[new_row][new_col] == 0) {
                        
                        queue.add(new State(new_row, new_col, distance + 1));
                    }
                }
                visited.add(row + " " + col);
            }
        }
        return -1;
    }
}