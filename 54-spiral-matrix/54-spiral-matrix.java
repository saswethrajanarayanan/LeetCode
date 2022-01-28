class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> output = new ArrayList<>();
        int j = 0;
        int row = 0;
        boolean[][] visited = new boolean[m][n];
        boolean progress = true;
        boolean left = true, right = true, up = true, down = true;
        if(m == 1) {
            for(int i = 0; i < matrix[0].length; ++i) {
                output.add(matrix[row][i]);
            }
            return output;
        }
        if(n == 1) {
            for(int i = 0; i < matrix.length; ++i) {
                output.add(matrix[i][j]);
            }
            return output;
        }
        while(progress) {
            if(right) {
                while(j < n) {
                    if(!visited[row][j]) {
                        visited[row][j] = true;
                        output.add(matrix[row][j++]); 
                    }
                    else {
                        row++;
                        j--;
                        if(visited[row][j]) {
                            progress = false;
                            break;
                        }
                        down = true;
                        up = false;
                        right = false;
                        left = false;
                        break;
                    }
                }
                if(right) {
                    row++;
                    j -= 1;   
                }
            }
            if(down) {
                while(row < m) {
                    if(!visited[row][j]) {
                        visited[row][j] = true;
                        output.add(matrix[row++][j]);
                    }
                    else {
                        row--;
                        j--;
                        if(visited[row][j]) {
                            progress = false;
                            break;
                        }
                        left = true;
                        right = false;
                        up = false;
                        down = false;
                        break;
                    }
                }
                if(down) {
                    row -= 1;
                    j--;   
                }
            }
            if(left) {
                while(j >= 0) {
                    if(!visited[row][j]) {
                        visited[row][j] = true;
                        output.add(matrix[row][j--]);
                    }
                    else {
                        row--;
                        j++;
                        if(visited[row][j]) {
                            progress = false;
                            break;
                        }
                        up = true;
                        down = false;
                        left = false;
                        right = false;
                        break;
                    }
                    
                }
                if(left) {
                    j++;
                    row -= 1;   
                }
            }
            if(up) {
                while(row >= 0) {
                    if(!visited[row][j]) {
                        visited[row][j] = true;
                        output.add(matrix[row--][j]);
                    }
                    else {
                        row++;
                        j++;
                        if(visited[row][j]) {
                            progress = false;
                            break;
                        }
                        right = true;
                        down = false;
                        left = false;
                        up = false;
                        break;
                    }
                }
                if(up) {
                    row++;
                    j += 1;
                }
            }
        }
        return output;
    }
}