class Solution {
    List<String> ans = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        helper(n, new StringBuilder(), 0, 0);
        return ans;
    }
    public void helper(int n, StringBuilder sb, int open, int close){
        //base case
        if(sb.length() == 2*n){
            ans.add(sb.toString());
            return;
        }
        
        if(open < n){
            sb.append('(');
            helper(n, sb, open+1, close);
            sb.deleteCharAt(sb.length()-1);
        }
        if(close < open){
            sb.append(')');
            helper(n, sb, open, close+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
