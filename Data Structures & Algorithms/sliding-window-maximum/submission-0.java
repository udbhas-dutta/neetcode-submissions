class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length-k+1];
        int index = 0;
        Deque<Integer> dq = new LinkedList<>();
        int i = 0, j = 0;
        while(j<nums.length){
            while(!dq.isEmpty() && nums[dq.getLast()] < nums[j]){
                dq.removeLast();
            }
            dq.addLast(j);

            if(i > dq.getFirst()){
                dq.removeFirst();
            }

            if((j+1)>=k){
                ans[i] = nums[dq.getFirst()];
                i++;
            }
            j++;
        }
        return ans;
    }
}
