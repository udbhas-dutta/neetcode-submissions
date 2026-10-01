class Solution {
    int[][] directions = {{-1,0}, {0,-1}, {1,0}, {0,1}};
    public int longestIncreasingPath(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        int[][]dp  = new int[rows][cols];
        for(int i = 0; i<dp.length; i++){
            Arrays.fill(dp[i], -1);
        }

        int ans = 0;
        for(int i = 0; i<rows; i++){
            for(int j = 0; j<cols; j++){
                ans = Math.max(ans, helper(matrix, i, j, Integer.MIN_VALUE, dp));
            }
        }
        return ans;
    }
    public int helper(int[][]matrix, int row, int col, int prev, int[][] dp){
        if(row<0 || row == matrix.length || col <0 || col == matrix[0].length 
        || matrix[row][col] <= prev) return 0;

        if(dp[row][col] != -1) return dp[row][col];

        int len = 1;
        for(int[] dir : directions){
            int newRow = row+dir[0];
            int newCol = col+dir[1];
            len = Math.max(len, 1 + helper(matrix, newRow, newCol, matrix[row][col], dp));
        }
        return dp[row][col] = len;
    }
}
