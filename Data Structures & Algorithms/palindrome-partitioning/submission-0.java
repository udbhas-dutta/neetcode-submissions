class Solution {
    List<List<String>> ans = new ArrayList<>();
    public List<List<String>> partition(String s) {
        helper(s, new ArrayList<>(), 0);
        return ans;
    }
    public void helper(String s, List<String> list, int index){
        if(index >= s.length()){
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int i = index; i<s.length(); i++){
            if(isPalindrome(s, index, i)){
                list.add(s.substring(index, i+1));
                helper(s, list, i+1);
                list.remove(list.size()-1);
            }
        }
    }
    public boolean isPalindrome(String s, int start, int end){
        while(start <= end){
            if(s.charAt(start)!= s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}
