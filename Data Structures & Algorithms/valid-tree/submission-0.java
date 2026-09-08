class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length > n-1) return false;

        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i<edges.length; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        Set<Integer> vis = new HashSet<>();
        if(!helper(0, -1, vis, adj)) return false;

        return vis.size() == n;
    }

    public boolean helper(int node, int parent, Set<Integer> vis, List<List<Integer>> adj){
        if(vis.contains(node)) return false;

        vis.add(node);
        for(int curr : adj.get(node)){
            if(curr == parent) continue;
            if(!helper(curr, node, vis, adj)) return false;
        }
        return true;
    }
}
