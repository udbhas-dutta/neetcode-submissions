class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        char[] map1 = new char[26];
        char[] map2 = new char[26];

        for(int i = 0; i<s1.length(); i++){
            map1[s1.charAt(i)-'a']++;
        }

        int i = 0;
        for(; i<s1.length(); i++){
            map2[s2.charAt(i)-'a']++;
        }
        if(Arrays.equals(map1, map2)) return true;

        int j = 0;
        while(i<s2.length()){
            map2[s2.charAt(j)-'a']--;
            map2[s2.charAt(i)-'a']++;

            if(Arrays.equals(map1, map2)) return true;
            i++;
            j++;
        }
        return false;

    }
}
