class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i<=n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
            boolean[] vis = new boolean[n+1];

            if(helper(u, -1, vis, adj)) return edge;
        }
        return new int[]{0,0};
    }
    public boolean helper(int curr, int parent, boolean[] vis, List<List<Integer>> adj){
        //base case
        if(vis[curr] == true) return true;

        vis[curr] = true;
        List<Integer> list = adj.get(curr);
        for(int i : list){
            if(i == parent) continue;
            if(helper(i, curr, vis, adj)) return true;
        }
        return false;
    }
}
