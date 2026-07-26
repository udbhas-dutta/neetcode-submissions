class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i : nums){
            set.add(i);
        }
        int ans = 0;
        for(int i : set){
            int count = 1;
            if(!set.contains(i-1)){
                int curr = i;
                while(set.contains(curr+1)){
                    curr+=1;
                    count++;
                }
                ans = Math.max(ans, count);
            }
        }
        return ans;
    }
}
