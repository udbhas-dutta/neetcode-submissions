class Solution {
    public boolean isPalindrome(String t) {
        String s = "";
        t = t.toLowerCase();
        for(int i = 0; i<t.length(); i++){
            char c = t.charAt(i);
            if((c>= '0' && c <='9') || (c>='a' && c<='z') || (c>='A' && c<='Z')) s+=c;
        }
        System.out.println(s);
        int i = 0, j = s.length()-1;
        while(i<=j){
            if(s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
