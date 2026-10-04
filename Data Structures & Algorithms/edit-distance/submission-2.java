class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()][word2.length()];
        for(int i = 0; i<dp.length; i++){
            Arrays.fill(dp[i], -1);
        }
        return helper(word1, word2, word1.length()-1, word2.length()-1, dp);
    }

    public int helper(String s, String t, int i, int j, int[][] dp) {
        //base case
        if(j < 0) return i+1;
        if(i < 0) return j+1;

        if(dp[i][j] != -1) return dp[i][j];


        if (s.charAt(i) == t.charAt(j)) {
            return dp[i][j] = 0 + helper(s, t, i - 1, j - 1, dp);
        } else {
            int ins = 1 + helper(s, t, i, j-1, dp);
            int del = 1 + helper(s, t, i-1, j, dp);
            int rep = 1 + helper(s, t, i-1,j-1, dp);
            return dp[i][j] = Math.min(ins, Math.min(del, rep));
        }
    }
}
