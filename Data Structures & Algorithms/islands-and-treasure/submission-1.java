class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                if(grid[i][j] == 0){
                    q.offer(new int[]{i,j});
                }
            }
        }
        if(q.size() == 0) return;
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int row = curr[0];
            int col = curr[1];
            for(int[] dir : directions){
                int newRow = row+dir[0];
                int newCol = col+dir[1];
                if(newRow < 0 || newRow>= grid.length || newCol <0 || newCol >= grid[0].length 
                || grid[newRow][newCol] != 2147483647) continue;
                
                q.offer(new int[]{newRow, newCol});
                grid[newRow][newCol] = grid[row][col] +1;
            }
        }
    }
}
