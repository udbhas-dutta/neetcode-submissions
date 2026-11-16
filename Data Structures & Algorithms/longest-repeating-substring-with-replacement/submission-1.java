class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int i = 0, j = 0;
        int ans = 0, freq = 0;
        while(j<s.length() && i <=j){
            char c = s.charAt(j);
            map.put(c, map.getOrDefault(c,0)+1);
            freq = Math.max(freq, map.get(c));

            while(j-i+1 - freq > k){
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)-1);
                i++;
            }
            ans = Math.max(ans, j-i+1);
            j++;
        }
        return ans;
    }
}
