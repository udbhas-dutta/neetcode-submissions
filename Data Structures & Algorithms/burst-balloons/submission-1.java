class Solution {
    public int maxCoins(int[] nums) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for(int i = 0; i<nums.length; i++){
            list.add(nums[i]);
        }
        list.add(1);
        int[][] dp = new int[list.size()][list.size()];
        for(int i = 0; i<dp.length; i++){
            Arrays.fill(dp[i], -1);
        }

        return helper(list, 1, list.size()-2, dp);
    }
    public int helper(List<Integer> list, int i, int j, int[][] dp){
        if(i>j) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        int ans = Integer.MIN_VALUE;
        for(int index = i; index <=j; index++){
            int curr = list.get(index)*list.get(i-1)*list.get(j+1) + 
            helper(list, i, index-1, dp) + helper(list, index+1, j, dp);
            ans = Math.max(ans, curr);
        }
        return dp[i][j] = ans;
    }
}
