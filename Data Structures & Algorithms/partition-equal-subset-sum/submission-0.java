class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i : nums){
            sum+=i;
        }
        if(sum%2 != 0 ) return false;
        int target = sum/2;
        Boolean[][] dp = new Boolean[nums.length][target+1];
        // for(int i = 0; i<dp.length; i++){
        //     Arrays.fill(dp[i], null);
        // }

        return helper(nums, target, nums.length-1, dp);
    }
    public boolean helper(int[] nums, int target, int index, Boolean[][]dp){
        //base case
        if(target == 0) return true;
        if(target < 0) return false;
        if(index == 0) return target == nums[index];

        if(dp[index][target] != null) return dp[index][target];

        boolean notPick = helper(nums, target, index-1, dp);

        boolean pick = false;
        if(target>=nums[index]){
            pick = helper(nums, target-nums[index], index-1, dp);
        }

        return dp[index][target] = pick || notPick;
    }
}
