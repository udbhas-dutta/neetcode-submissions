class Solution {
    public int climbStairs(int n) {
        int dp[] = new int[n+1];
        Arrays.fill(dp, -2);
        return helper(n, dp);
    }
    public int helper(int n, int[] dp){
        if(n == 0) return 1;
        if(n<0) return 0;

        if(dp[n] != -2) return dp[n];

        int a = helper(n-1, dp);
        int b = helper(n-2, dp);

        return dp[n] = a+b;
    }
}
