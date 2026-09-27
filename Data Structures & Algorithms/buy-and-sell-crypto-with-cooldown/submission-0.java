class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for(int i = 0; i<dp.length; i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(prices, 0, 0, dp);
    }
    public int helper(int[] nums, int index, int buy, int[][]dp){
        //buy == 0 - > can buy, buy == 1 -> already bought, can only sell
        if(index >= nums.length){
            return 0;
        }
        if(dp[index][buy] != -1) return dp[index][buy];

        if(buy == 0){
            return dp[index][buy] = Math.max(-nums[index]+helper(nums, index+1, 1, dp), 
            0+helper(nums, index+1, 0, dp)); 
        } else {
            return dp[index][buy] = Math.max(nums[index] + helper(nums, index+2, 0, dp), 
            0+helper(nums, index+1, 1, dp));
        }
    }
}
