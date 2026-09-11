class Pair{
    String word;
    int steps;
    public Pair(String word, int steps){
        this.word = word;
        this.steps = steps;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        Set<String> set = new HashSet<>();
        for(String s : wordList){
            set.add(s);
        }
        q.offer(new Pair(beginWord, 1));
        set.remove(beginWord);
        while(!q.isEmpty()){
            Pair curr = q.poll();
            String word = curr.word;
            int steps = curr.steps;
            if(word.equals(endWord)) return steps;
            
            for(int i = 0; i<word.length(); i++){
                for(char ch = 'a'; ch<='z'; ch++){
                    StringBuilder sb = new StringBuilder(word);
                    sb.setCharAt(i, ch);
                    String newWord = sb.toString();
                    if(set.contains(newWord)){
                        set.remove(newWord);
                        q.offer(new Pair(newWord, steps+1));
                    }

                }
            }
        }
        return 0;
    }
}
