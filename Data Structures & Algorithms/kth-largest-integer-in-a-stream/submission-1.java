class KthLargest {
    int k;
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(int i = 0; i<nums.length; i++){
            if(pq.size() == k){
                if(nums[i] > pq.peek()){
                    pq.poll();
                    pq.offer(nums[i]);
                }
            } else {
                pq.offer(nums[i]);
            }
        }
    }
    
    public int add(int val) {
        if(pq.size() == k){
            if(val > pq.peek()){
                pq.poll();
                pq.offer(val);
            }
        } else {
            pq.offer(val);
        }
        return pq.peek();
    }
}
