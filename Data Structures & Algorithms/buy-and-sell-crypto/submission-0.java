class Solution {
    public int maxProfit(int[] prices) {
        int ans = 0;
        int min = prices[0];
        for(int i = 0; i< prices.length; i++){
            int profit = prices[i]- min;
            min = Math.min(min, prices[i]);
            ans = Math.max(ans, profit);
        }
        return ans;
    }
}
