class Solution {
    int time = 0;
    int fresh = 0;
    Queue<int[]> q = new LinkedList<>();
    public int orangesRotting(int[][] grid) {

        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[i].length; j++){
                if(grid[i][j] == 1) fresh++;
                else if(grid[i][j] == 2) q.add(new int[]{i,j});
            }
        }
        return helper(grid);
    }
    public int helper(int[][] grid){
        int[][]directions = {{-1,0}, {0,-1}, {1,0}, {0,1}};
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i<size; i++){
                int[] curr = q.poll();
                int r = curr[0], col = curr[1];
                for(int[] dir : directions){
                    int new_row = dir[0]+r;
                    int new_col = dir[1]+col;
                    if(new_row >=0 && new_col >=0 && new_row <grid.length && new_col <grid[0].length 
                    && grid[new_row][new_col] == 1){
                        grid[new_row][new_col] = 2;
                        fresh--;
                        q.offer(new int[]{new_row, new_col});
                    }
                }
            }
             
            if(!q.isEmpty()) time++;
        }
        return fresh == 0 ? time : -1;
    }
}
