class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return helper(s, set, 0, dp);
    }
    public boolean helper(String s, Set<String> set, int index, int[] dp){
        if(index == s.length()) return true;

        for(int i = index; i<s.length(); i++){
            
            if(dp[index] != -1) return dp[index] == 1; 

            String curr = s.substring(index, i+1);
            if(set.contains(curr) && helper(s, set, i+1, dp)){
                dp[i] = 1;
                return true;
            }
        }
        dp[index] = 0;   
        return false;
    }
}
