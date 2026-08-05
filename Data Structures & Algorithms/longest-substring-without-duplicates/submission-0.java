class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int i = 0, j = 0;
        int ans = 0;
        while(j<s.length()){
            char curr = s.charAt(j);
            if(map.containsKey(curr)){
                if(map.get(curr) >= i){
                    i = map.get(curr)+1;
                }
            }
            map.put(curr, j);
            ans = Math.max(ans, j-i+1);
            j++;
        }
        return ans;
    }
}
