class Solution {
    public int coinChange(int[] coins, int amount) {
        int ans = helper(coins, amount, coins.length - 1);
        return ans >= 10000? -1 : ans;
    }
    public int helper(int[] coins, int target, int index) {
        // base case
        if (index == 0) {
            if (target % coins[index] == 0) {
                return target / coins[index];
            } else {
                return 10001;
            }
        }

        int notPick = helper(coins, target, index - 1);
        int pick = Integer.MAX_VALUE;
        if (target >= coins[index]) {
            pick = 1 + helper(coins, target - coins[index], index);
        }

        return Math.min(pick, notPick);
    }
}
