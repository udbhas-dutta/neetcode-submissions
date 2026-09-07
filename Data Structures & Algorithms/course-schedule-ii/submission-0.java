class Solution {
    public int[] findOrder(int numCourses, int[][] pre) {
        //topo sort using Kahn's Algorithm
        List<List<Integer>> adj = new ArrayList<>();
        int[] ans = new int[numCourses];

        for(int i = 0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i<pre.length; i++){
            adj.get(pre[i][1]).add(pre[i][0]);
        }

        int[] indegree = new int[numCourses];
        for(int i = 0; i<numCourses; i++){
            List<Integer> curr = adj.get(i);
            for(int j : curr){
                indegree[j]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i<indegree.length; i++){
            if(indegree[i] == 0) q.offer(i);
        }

        int index = 0; // iterator for the answer array

        while(!q.isEmpty()){
            int curr = q.poll();
            ans[index++] = curr;

            List<Integer> list = adj.get(curr);
            for(int i : list){
                indegree[i]--;
                if(indegree[i] == 0) q.offer(i);
            }
        }
        return index == ans.length ? ans : new int[]{};
    }
}
