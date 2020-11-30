class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> valid_check = new HashSet();
        for(int i = 0; i < 9; ++i){
            for(int j = 0; j < 9; ++j){
                char current = board[i][j];
                if(current != '.'){
                    if(!valid_check.add(current + "found at row" + i) ||
                      !valid_check.add(current + "found at column" + j) ||
                      !valid_check.add(current + "found at box" + i/3 + "-" + j/3)) return false; 
                }
            }
        }
        return true;
    }
}
