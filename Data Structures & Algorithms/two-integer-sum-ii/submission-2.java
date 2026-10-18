class Solution {
    public int[] twoSum(int[] nums, int target) {
        int i = 0, j = nums.length-1;
        while(i<=j){
            int a = nums[i], b = nums[j];
            int sum = a+b;
            if(sum > target) j--;
            else if(sum < target) i++;
            else return new int[]{i+1,j+1};
        }
        return null;
    }
}
