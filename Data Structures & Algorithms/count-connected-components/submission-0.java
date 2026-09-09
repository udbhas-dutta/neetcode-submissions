class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i<edges.length; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        boolean[]vis = new boolean[n];
        int count = 0;
        for(int i = 0; i<n; i++){
            if(vis[i] == false){
                helper(adj, i, vis);
                count++;
            }
        }
        return count;
    }
    public void helper(List<List<Integer>> adj, int curr, boolean[] vis){
        if(vis[curr] == true) return;

        vis[curr] = true;
        List<Integer> list = adj.get(curr);
        for(int i : list){
            helper(adj, i, vis);
        }
    }
}
