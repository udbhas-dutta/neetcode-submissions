class Solution {
    public int swimInWater(int[][] grid) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int[][] directions = {{-1,0},{0,-1},{1,0}, {0,1}};
        boolean[][]vis = new boolean[grid.length][grid[0].length];

        pq.offer(new int[]{grid[0][0], 0, 0});
        vis[0][0] = true;

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int val = curr[0], row = curr[1], col = curr[2];
            if(row == grid.length-1 && col == grid[0].length-1) return val;

            for(int[] dir : directions){
                int next_row = row + dir[0];
                int next_col = col + dir[1];

                if(next_row >=0 && next_row < grid.length && next_col >=0 && next_col < grid[0].length && 
                !vis[next_row][next_col]) {

                    int max = Math.max(val, grid[next_row][next_col]); 
                    pq.offer(new int[]{max, next_row, next_col});
                    vis[next_row][next_col] = true;
                }
            }
        }
        return -1;

    }
}
