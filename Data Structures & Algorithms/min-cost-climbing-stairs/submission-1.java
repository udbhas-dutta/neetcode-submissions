class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        Arrays.fill(dp, -1);
        return Math.min(helper(cost, 0, dp), helper(cost, 1, dp));
    }
    public int helper(int[] cost, int index, int[] dp){
        if(index >= cost.length) return 0;

        if(dp[index] != -1) return dp[index];

        return dp[index] = cost[index] + Math.min(helper(cost, index+1, dp), helper(cost, index+2, dp));
    }
}
