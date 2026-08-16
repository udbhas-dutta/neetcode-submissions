class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i<9; i++){
            for(int j = 0; j<9; j++){
                if(board[i][j] != '.'){
                    char curr = board[i][j];
                    if(helper(board, i, j, curr) == false) return false;
                }
            }
        }
        return true;
    }
    public boolean helper(char[][] board, int row, int col, char curr){
        //row check
        for(int i = 0; i<9; i++){
            if(i != row && board[i][col] == curr) return false;
        }
        
        //col check
        for(int i = 0; i<9; i++){
            if(i != col && board[row][i] == curr) return false;
        }

        //box check
        for(int i = 0; i<9; i++){
            int r = 3*(row/3)+i/3;
            int c = 3*(col/3)+i%3;
            if(r != row && c != col && board[r][c] == curr) return false;
        }

        return true;
    }
}
