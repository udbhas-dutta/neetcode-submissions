class Solution {
    List<List<String>> ans = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][]board = new char[n][n];
        for(int i = 0; i<board.length; i++){
            Arrays.fill(board[i],'.');
        }
        //memo arrays to avoid repeated looping
        int[] leftRow = new int[n];
        int[] lower_diag = new int[2*n+1];
        int[] upper_diag = new int[2*n+1];
        helper(board, leftRow, lower_diag, upper_diag, 0, n);
        return ans;
    }
    public void helper(char[][]board, int[] left_row, int[] lower_diag, int[] upper_diag, int col, int n){
        //base case
        if(col == n){
            List<String> list = new ArrayList<>();
            for(int i = 0; i<n; i++){
                list.add(new String(board[i]));
            }
            ans.add(list);
            return;
        }

        //check
        for(int row = 0; row<n; row++){
            //check if safe to place
            if(left_row[row] == 0 && lower_diag[row+col] == 0 && upper_diag[n-1 +col-row] == 0){
                //place queen
                board[row][col] = 'Q';
                left_row[row] = 1;
                lower_diag[row+col] = 1;
                upper_diag[n-1 + col-row] = 1;

                //recursion for next col
                helper(board, left_row, lower_diag, upper_diag, col+1, n);

                //backtrack
                board[row][col] = '.';
                left_row[row] = 0;
                lower_diag[row+col] = 0;
                upper_diag[n-1 + col-row] = 0;
            }
        }
    }
}
