class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        helper(nums, 0);
        return ans;
    }
    public void helper(int[] nums, int index){
        //base case
        if(index == nums.length){
            List<Integer> list = new ArrayList<>();
            for(int i : nums){
                list.add(i);
            }
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int i = index; i<nums.length; i++){
            swap(nums, i, index);
            helper(nums, index+1);
            swap(nums, i, index);
        }
        
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
