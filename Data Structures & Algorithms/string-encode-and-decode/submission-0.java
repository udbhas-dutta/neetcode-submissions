class Solution {
    List<String> org;
    public String encode(List<String> strs) {
        org = new ArrayList<>(strs);
        String s = "";
        for(int i = 0; i<strs.size(); i++){
            s+=strs.get(i);
        }
        return s;
    }

    public List<String> decode(String str) {
        return org;
    }
}
