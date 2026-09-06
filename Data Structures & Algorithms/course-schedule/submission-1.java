class Solution {
    public boolean canFinish(int numCourses, int[][] pre) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] state = new int[numCourses];

        for(int i = 0; i<numCourses; i++){
            map.put(i, new ArrayList<Integer>());
        }

        for(int i = 0; i<pre.length; i++){
            List<Integer> list = map.get(pre[i][0]);
            list.add(pre[i][1]);
        }

        for(int i = 0; i<numCourses; i++){
            if (helper(map, i, state) == false) return false;
        }
        return true;
    }
    public boolean helper(Map<Integer, List<Integer>> map, int curr, int[] state){
        // currently visiting -> cycle
        if (state[curr] == 1) {
            return false;
        }

        // already completely processed -> no cycle
        if (state[curr] == 2) {
            return true;
        }

        // mark as currently visiting
        state[curr] = 1;

        for (int i : map.get(curr)) {
            if (!helper(map, i, state)) {
                return false;
            }
        }

        // completely processed
        state[curr] = 2;

        return true;
    }
}
