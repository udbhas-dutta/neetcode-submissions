class Solution {
    int ans = 0;
    public int maxAreaOfIsland(int[][] grid) {
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[i].length; j++){
                if(grid[i][j] == 1){
                    ans = Math.max(ans,helper(grid, i, j, 0));
                }
            }
        }
        return ans;
    }
    public int helper(int[][]grid, int i, int j, int count){
        if(i<0 || j <0 || i == grid.length || j == grid[i].length) return 0;
        if(grid[i][j] == 0) return 0;


        grid[i][j] = 0;
        return 1 + helper(grid, i, j+1, count)
        +helper(grid, i, j-1, count)
        +helper(grid, i-1, j, count)
        +helper(grid, i+1, j, count);
    }
}
