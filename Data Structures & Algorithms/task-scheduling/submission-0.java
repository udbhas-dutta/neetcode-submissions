class Pair{
    int frequency;
    int idleTime;

    public Pair(int frequency, int idleTime){
        this.frequency = frequency;
        this.idleTime = idleTime;
    }
}
class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : tasks){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Pair> q = new LinkedList<>();
        for(char c : map.keySet()){
            pq.offer(map.get(c));
        }
        int time = 0;
        while(!pq.isEmpty() || !q.isEmpty()){
            time++;
            
            if(!pq.isEmpty()){
                int curr = pq.poll();
                if(curr-1 >0) q.offer(new Pair(curr-1, time+n));
            }

            if(!q.isEmpty() && q.peek().idleTime == time){
                Pair curr = q.poll();
                pq.offer(curr.frequency);
            }
        }
        return time;
    }
}
