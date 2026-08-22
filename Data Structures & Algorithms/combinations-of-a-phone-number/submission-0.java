class Solution {
    List<String> ans = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return ans;
        Map<Integer, String> map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");

        helper(map, digits, new StringBuilder(), 0);
        return ans;
    }
    public void helper(Map<Integer, String> map, String digits, StringBuilder sb, int index){
        //base case
        if(sb.length() == digits.length()){
            ans.add(sb.toString());
            return;
        }

        String curr = map.get(digits.charAt(index)-'0');
        for(int i = 0; i<curr.length(); i++){
            sb.append(curr.charAt(i));
            helper(map, digits, sb, index+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
