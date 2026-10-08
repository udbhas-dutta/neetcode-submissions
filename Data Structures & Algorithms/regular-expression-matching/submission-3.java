class Solution {
    public boolean isMatch(String s, String t) {
        return helper(s, t, s.length()-1, t.length()-1);
    }
    public boolean helper(String s, String t, int i, int j){
        //base case
        if(i<0 && j<0) return true;
        if(i>=0 && j<0) return false;
        if(i<0 && j>=0){
            for(int k = j; k>=0; k-=2){
                if(t.charAt(k) != '*')return false;
            }
            return true;
        }

        if(s.charAt(i) == t.charAt(j) || t.charAt(j) == '.'){
            return helper(s, t, i-1, j-1);
        } else if(t.charAt(j) == '*'){
            boolean match = t.charAt(j-1) == '.' || t.charAt(j-1) == s.charAt(i);
            return helper(s, t, i, j-2) || (match && helper(s, t, i-1, j));
        } else {
            return false;
        }
    }
}
