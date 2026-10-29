class Pair{
    int dest;
    int cost;
    public Pair(int dest, int cost){
        this.dest = dest;
        this.cost = cost;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i<flights.length; i++){
            adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        }

        Queue<int[]> q = new LinkedList<>();
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        q.offer(new int[]{0, src, 0});
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int stops = curr[0];
            int node = curr[1];
            int cost = curr[2];

            if(stops > k) continue;

            for(Pair p : adj.get(node)){
                int next = p.dest;
                int next_cost = p.cost;

                if(cost + next_cost < dist[next] && stops <= k) {
                    dist[next] = cost + next_cost;
                    q.offer(new int[]{stops+1, next, cost+next_cost});
                }
            }
        }
        return dist[dst] == Integer.MAX_VALUE? -1 : dist[dst];
    }
}
