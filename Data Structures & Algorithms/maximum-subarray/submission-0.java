class Solution {
    public int maxSubArray(int[] nums) {
        int ans = Integer.MIN_VALUE, max_n = Integer.MIN_VALUE, neg = 0;
        int sum = 0;
        for(int i = 0; i<nums.length; i++){
            sum+=nums[i];
            ans = Math.max(ans, sum);
            if(nums[i] <0) {
                max_n = Math.max(max_n, nums[i]);
                neg++;
            }
            if(sum <0){
                sum = 0;
            }
        }
        return neg == nums.length ? max_n : ans;
    }
}
