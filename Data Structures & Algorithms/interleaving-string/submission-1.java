class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        Boolean[][] dp = new Boolean[s1.length()+1][s2.length()+1];
        return helper(s1, s2, s3, 0, 0, 0, dp);
    }
    public boolean helper(String a, String b, String c, int i, int j, int k, Boolean[][]dp){
        //base case
        if(k == c.length()){
            return i == a.length() && j == b.length();
        }
        if(dp[i][j] != null) return dp[i][j];

        boolean left = false, right = false;
        if(i<a.length() && a.charAt(i) == c.charAt(k)){
            left = helper(a, b, c, i+1, j, k+1, dp);
        }
        if(j<b.length() && b.charAt(j) == c.charAt(k)){
            right = helper(a, b, c, i, j+1, k+1, dp);
        }

        return dp[i][j] = left || right;
    }
}
