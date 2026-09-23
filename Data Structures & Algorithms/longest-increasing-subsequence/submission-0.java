class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        for(int i = 0; i< dp.length; i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(nums, 0, -1, dp);
    }
    public int helper(int[] nums, int index, int prev, int[][]dp){
        //base case
        if(index == nums.length) return 0;

        if(dp[index][prev+1] != -1) return dp[index][prev+1];

        int notPick = helper(nums, index+1, prev, dp);

        int pick = -1;
        if(prev == -1 || nums[prev] < nums[index]){
            pick = 1 + helper(nums, index+1, index, dp);
        }

        return dp[index][prev+1] = Math.max(pick, notPick);
    }
}
