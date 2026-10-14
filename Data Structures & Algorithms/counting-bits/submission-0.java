class Solution {
    public int[] countBits(int n) {
        int[] dp = new int[n+1];
        int ref = 1;

        for(int i = 1; i<=n; i++){
            if(ref *2 == i){
                ref = i;
            }
            dp[i] = 1 + dp[i-ref];
        }
        return dp;
    }
}
