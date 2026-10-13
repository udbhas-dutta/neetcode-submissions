class Pair{
    int node;
    int dist;
    public Pair(int node, int dist){
        this.node = node;
        this.dist = dist;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0; i<=n; i++){
            adj.add(i, new ArrayList<>());
        }
        for(int i = 0; i<times.length; i++){
            adj.get(times[i][0]).add(new Pair(times[i][1], times[i][2]));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt((Pair p) -> p.dist));
        pq.offer(new Pair(k,0));
        int[] ans = new int[n+1];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[k] = 0;

        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int dist = curr.dist;
            int node = curr.node;
            for(Pair p : adj.get(node)){
                int nextNode = p.node;
                int nextDist = p.dist;

                int total = dist+nextDist;
                if(ans[nextNode] > total){
                    ans[nextNode] = total;
                    pq.add(new Pair(nextNode, ans[nextNode]));
                }
            }
        }
        int max = ans[1];
        for(int i = 1; i<=n; i++){
            if(ans[i] == Integer.MAX_VALUE) return -1;
            max = Math.max(max, ans[i]);
        }
        return max;
    }
}
