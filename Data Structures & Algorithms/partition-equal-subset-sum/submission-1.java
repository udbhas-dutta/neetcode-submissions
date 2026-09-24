class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i : nums){
            sum+=i;
        }
        if(sum%2 != 0 ) return false;
        int target = sum/2;
        int[][] dp = new int[nums.length][target+1];
        for(int i = 0; i<dp.length; i++){
            Arrays.fill(dp[i], -1);
        }

        return helper(nums, target, nums.length-1, dp);
    }
    public boolean helper(int[] nums, int target, int index, int[][]dp){
        //base case
        if(target == 0) return true;
        if(target < 0) return false;
        if(index == 0) return target == nums[index];

        if(dp[index][target] != -1) return dp[index][target] == 1;

        boolean notPick = helper(nums, target, index-1, dp);

        boolean pick = false;
        if(target>=nums[index]){
            pick = helper(nums, target-nums[index], index-1, dp);
        }

        if(pick || notPick == true){
            dp[index][target] = 1;
        } else {
            dp[index][target] = 0;
        }
        return dp[index][target] == 1;
    }
}
