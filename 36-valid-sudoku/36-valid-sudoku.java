class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> rows = new HashSet<>();
        HashSet<String> cols = new HashSet<>();
        HashSet<String> box = new HashSet<>();
        if(board.length < 9 || board.length != board[0].length) return false;
        for(int i = 0; i < board.length; ++i) {
            for(int j = 0; j < board[i].length; ++j) {
                if(Character.toString(board[i][j]).equals(".")) continue;
                String addRow = board[i][j] + "Row" + Integer.toString(i); 
                String addCol = board[i][j] + "Col" + Integer.toString(j);
                String addBox = board[i][j] + "Box" + Integer.toString(i / 3) + "," + Integer.toString(j / 3);
                if(!rows.contains(addRow) && !cols.contains(addCol) && !box.contains(addBox)) {
                    rows.add(addRow);
                    cols.add(addCol);
                    box.add(addBox);
                }
                else {
                    return false;
                }
            }
        }
        return true;
    }
}