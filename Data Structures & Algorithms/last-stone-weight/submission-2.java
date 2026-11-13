class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i<stones.length;i++){
            pq.offer(stones[i]);
        } 
        while(pq.size()>=2){
            int a = pq.poll();
            int b = pq.poll();
            int res = a-b;
            if(res>0)pq.offer(res);
            if(pq.size() <= 1) break;
        }
        return pq.size() > 0 ? pq.peek() : 0;
    }
}
