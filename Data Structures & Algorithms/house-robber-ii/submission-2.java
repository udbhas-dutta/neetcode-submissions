class Solution {
    public int rob(int[] nums) {
        // List<Integer> temp1 = new ArrayList<>();
        // List<Integer> temp2 = new ArrayList<();
        if(nums.length == 1) return nums[0];
        if(nums.length ==2) return Math.max(nums[0], nums[1]);

        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        int ans1 = helper(nums, 0, nums.length-2, dp);
        Arrays.fill(dp, -1);
        int ans2 = helper(nums, 1, nums.length-1, dp);
        return Math.max(ans1, ans2);
    }
    public int helper(int[] nums, int start, int index, int[] dp){
        if(index < start) return 0;

        if(dp[index] != -1) return dp[index];

        int pick = nums[index] + helper(nums, start, index-2, dp);

        int notPick = helper(nums, start, index-1, dp);

        return dp[index] = Math.max(pick, notPick);
    }
}
