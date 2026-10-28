class Solution {
    public String foreignDictionary(String[] words) {
        Map<Character, Set<Character>> adj = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();

        for (String word : words) {
            for(char c : word.toCharArray()){
                adj.putIfAbsent(c, new HashSet<>());
                indegree.putIfAbsent(c, 0);
            }
        }

        for(int i = 0; i< words.length -1; i++){
            String s1 = words[i];
            String s2 = words[i+1];
            int len = Math.min(s1.length(), s2.length());
            if(s1.length() > s2.length() && s1.substring(0,len).equals(s2.substring(0,len))){
                return "";
            }
            for(int j = 0; j<len; j++){
                if(s1.charAt(j) != s2.charAt(j)){
                    if (!adj.get(s1.charAt(j)).contains(s2.charAt(j))){
                        adj.get(s1.charAt(j)).add(s2.charAt(j));
                        indegree.put(s2.charAt(j), indegree.get(s2.charAt(j))+1);
                    }
                    break;
                }
            }
        }
        Queue<Character> q = new LinkedList<>();

        for(char c : indegree.keySet()){
            if(indegree.get(c) == 0) q.offer(c);
        }

        StringBuilder ans = new StringBuilder();
        while(!q.isEmpty()){
            char curr = q.poll();
            ans.append(curr);
            Set<Character> set = adj.get(curr);
            for(char c : set){
                indegree.put(c, indegree.get(c)-1);
                if(indegree.get(c) == 0) q.offer(c);
            }
        }

        if(ans.length() != indegree.size()) return "";
        return ans.toString();

    }
}
