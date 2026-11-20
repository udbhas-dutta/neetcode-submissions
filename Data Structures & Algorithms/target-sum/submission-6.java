class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int[][]dp = new int[nums.length][42002];
        for(int i = 0; i<nums.length; i++){
            Arrays.fill(dp[i], -1);
        }
        return helper(nums, target, nums.length-1, dp);
    }
    public int helper(int[] nums, int target, int index, int[][]dp){
        //base case
        if(index == 0) {
            if(target == 0  && nums[0] == 0) return 2;

            if(target == nums[0] || target == -nums[0]) return 1;

            return 0;
        }
        if(dp[index][target+21001] != -1) return dp[index][target+21001];
        
        int left = helper(nums, target-nums[index], index-1, dp);
        int right = helper(nums, target+nums[index], index-1, dp);

        return dp[index][target+21001] = left+right;
    }
}
