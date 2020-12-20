class Solution {
    int count = 0;
    public int countBattleships(char[][] board) {
        int counter = 0;
        for(int i = 0; i < board.length; ++i) {
            for(int j = 0; j < board[i].length; ++j) {
                if(board[i][j] == 'X') {
                    counter++;
                    btrack(board, i, j);
            }
          }
        }
        return counter;
    }
    private void btrack(char[][] board, int i, int j) {
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '.') {
            return;
        }
        board[i][j] = '.';
        btrack(board, i + 1, j);
        btrack(board, i, j + 1);
    }
}
