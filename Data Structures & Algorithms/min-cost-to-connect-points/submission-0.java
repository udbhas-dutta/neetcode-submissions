class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for(int i = 0; i<n; i++){
            int x1 = points[i][0];
            int y1 = points[i][1];
            for(int j = i+1; j<n; j++){
                int x2 = points[j][0];
                int y2 = points[j][1];
                int dist = Math.abs(x1-x2) + Math.abs(y1-y2);
                adj.computeIfAbsent(i, k-> new ArrayList<>()).add(new int[]{dist, j});
                adj.computeIfAbsent(j, k-> new ArrayList<>()).add(new int[]{dist, i});
            }
        }

        int ans = 0;
        Set<Integer> vis = new HashSet<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a-> a[0]));
        pq.offer(new int[]{0,0});
        while(vis.size() < n){
            int[] curr = pq.poll();
            int cost = curr[0];
            int i = curr[1];
            if(vis.contains(i)) continue;
            ans+=cost;
            vis.add(i);
            for(int[] next : adj.getOrDefault(i, Collections.emptyList())){
                int n_cost = next[0];
                int n_index = next[1];
                if(!vis.contains(n_index)){
                    pq.offer(new int[]{n_cost, n_index});
                }
            }
        }
        return ans;
    }
}
