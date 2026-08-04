class Solution {
    public int findDuplicate(int[] nums) {
        //hare and turtle, linked list cycle detection
        int slow = nums[0], fast = nums[0];
        slow = nums[slow];
        fast = nums[nums[fast]];

        //step 1: checking if cycle exists
        while(slow != fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        //step2: finding out the point of the cycle
        slow = nums[0];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
