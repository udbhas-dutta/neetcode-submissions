class Solution {
    int[][] directions = {{-1,0}, {0,-1},{1,0}, {0,1}};
    public void solve(char[][] board) {
        int rows = board.length; 
        int cols = board[0].length;

        for(int i = 0; i<rows; i++){
            if(board[i][0] == 'O'){
                helper(board, i, 0);
            }
            if(board[i][cols-1] == 'O'){
                helper(board, i, cols-1);
            }
        }

        for(int i = 0; i<cols; i++){
            if(board[0][i] == 'O'){
                helper(board, 0, i);
            }
            if(board[rows-1][i] == 'O'){
                helper(board, rows-1, i);
            }
        }

        for(int i = 0; i<rows; i++){
            for(int j= 0; j<cols; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                } else if (board[i][j] == 'T'){
                    board[i][j] = 'O';
                }
            }
        }
    }
    public void helper(char[][]board, int row, int col){
        board[row][col] = 'T';
        for(int[] dir : directions){
            int newRow = row+dir[0], newCol = col+dir[1];
            if(newRow>=0 && newRow<board.length && newCol >=0 && newCol<board[0].length 
            && board[newRow][newCol] == 'O'){
                helper(board, newRow, newCol);
            }
        }
    }
}
