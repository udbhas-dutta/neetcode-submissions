class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][]dp = new int[m][n];
        for(int i = 0; i<m; i++){
            Arrays.fill(dp[i],-1);
        }

        return helper(text1, text2, m - 1, n - 1, dp);
    }
    public int helper(String s, String t, int i, int j, int[][] dp) {
        // base case
        if (i < 0 || j < 0) {
            return 0;
        }
        if(dp[i][j] != -1) return dp[i][j];

        if (s.charAt(i) == t.charAt(j)) {
            return dp[i][j] = 1 + helper(s, t, i - 1, j - 1, dp);
        } else {
            return dp[i][j] = Math.max(helper(s, t, i, j - 1, dp), helper(s, t, i - 1, j, dp));
        }
    }
}
