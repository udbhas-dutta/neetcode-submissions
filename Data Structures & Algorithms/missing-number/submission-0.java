class Solution {
    public int missingNumber(int[] nums) {
        int curr = nums.length;
        for(int i = 0; i<nums.length; i++){
            curr  = curr ^i;
            curr = curr ^ nums[i];
        }
        return curr;   
    }
}
