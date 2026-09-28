class Solution {
    public int change(int amount, int[] coins) {
        int[][]dp = new int[amount+1][coins.length];
        for(int i = 0; i<dp.length; i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(amount, coins, coins.length-1, dp);
    }
    public int helper(int target, int[] nums, int index, int[][]dp){
        if(target == 0) return 1;
        if(index == 0) return target % nums[index] == 0 ? 1 : 0;

        if(dp[target][index] != -1) return dp[target][index];

        int notPick = helper(target, nums, index-1, dp);
        int pick = 0;
        if(target >= nums[index]){
            pick = helper(target- nums[index], nums, index, dp);
        }

        return dp[target][index] = pick + notPick;

    }
}
