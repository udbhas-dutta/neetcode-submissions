class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i<t.length(); i++){
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i),0)+1);
        }
        int i = 0, j = 0;
        int count = 0;
        int minLen = s.length()+1;
        int start = -1;
        while(j < s.length()){
            if(map.getOrDefault(s.charAt(j),0) > 0) count++;
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j),0)-1);
            while(count == t.length() && i<s.length()){
                if(j-i+1 < minLen){
                    minLen = j-i+1;
                    start = i;
                }
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
                if(map.get(s.charAt(i))>0) count--;
                i++;
            }
            j++;
        }
        return start == -1 ? "" : s.substring(start, start+minLen);
    }
}
