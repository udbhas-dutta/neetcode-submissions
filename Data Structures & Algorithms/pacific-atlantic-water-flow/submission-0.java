class Solution {
    int[][]directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length, cols = heights[0].length;
        List<List<Integer>> ans = new ArrayList<>();

        boolean[][]pac = new boolean[rows][cols];
        boolean[][]atl = new boolean[rows][cols];

        for(int i = 0; i<rows; i++){
            helper(i, 0, pac, heights);
            helper(i, cols-1, atl, heights);
        }

        for(int i = 0; i<cols; i++){
            helper(0,i, pac, heights);
            helper(rows-1, i, atl, heights);
        }

        for(int i = 0; i<rows; i++){
            for(int j = 0; j<cols; j++){
                if(pac[i][j] == true && atl[i][j] == true){
                    ans.add(Arrays.asList(i,j));
                }
            }
        }
        return ans;
    }
    public void helper(int row, int col, boolean[][] ocean, int[][]heights){
        ocean[row][col] = true;
        for(int[] dir : directions){
            int newRow = row+dir[0], newCol = col+dir[1];
            if(newRow>=0 && newCol >=0 && newRow<heights.length && newCol <heights[0].length 
            && ocean[newRow][newCol] == false && heights[newRow][newCol] >= heights[row][col]){
                helper(newRow, newCol, ocean, heights);
            }
        }
    }
}
