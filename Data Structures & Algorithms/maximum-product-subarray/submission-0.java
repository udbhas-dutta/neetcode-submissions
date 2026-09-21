class Solution {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int min = 1, max = 1;
        int ans = nums[0];

        for(int i : nums){
            int temp = max*i;

            max = Math.max(Math.max(i*max, i*min), i);
            min = Math.min(Math.min(temp, i*min), i);
            ans = Math.max(ans, max);
        }

        return ans;
    }
}
