class Solution {
    public List<List<String>> solveNQueens(int n) {
        int[] columns = new int[n];
        List<List<String>> result = new ArrayList();
        solve(result, columns, 0, n);
        return result;
    }
    public void solve(List<List<String>> result, int[] columns, int rows, int n) {
        if(rows == n) {
            result.add(new ArrayList(convert(columns)));
            return;
        }
        for(int col = 0; col < n; ++col) {
            if(allowedToPlace(rows, col, columns)) {
                columns[rows] = col;
                solve(result, columns, rows + 1, n);
            }
        }
    }
    public boolean allowedToPlace(int rows, int col, int[] columns) {
        for(int row = 0; row < rows; ++row) {
            int column = columns[row];
            if(column == col) {
                return false;
            }
            int entity0 = Math.abs(col - column);
            int entity1 = rows - row;
            if(entity0 == entity1) {
                return false;
            }
        }
        return true;
    }
    public List<String> convert(int[] columns) {
        List<String> sub_res = new ArrayList();
        char c = '.';
        String placement = "";
        for(int pos: columns) {
            for(int i = 0; i < columns.length; ++i) {
                if(i == pos) {
                    c = 'Q';
                }
                placement += c;
                c = '.';
            }
            sub_res.add(placement);
            placement = "";
        }
        return sub_res;
    }
}