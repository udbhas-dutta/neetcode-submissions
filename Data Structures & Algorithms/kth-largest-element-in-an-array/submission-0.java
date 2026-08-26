class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i : nums){
            if(pq.size() == k){
                if(i>pq.peek()){
                    pq.poll();
                    pq.offer(i);
                }
            } else {
                pq.offer(i);
            }
        }
        return pq.peek();
    }
}
