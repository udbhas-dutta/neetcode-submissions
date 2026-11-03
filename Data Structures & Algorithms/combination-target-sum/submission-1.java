class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        helper(nums, target, 0, new ArrayList<Integer>());
        return ans;
    }
    public void helper(int[] nums, int target, int index, List<Integer> list){
        //base case
        if(target == 0){
            ans.add(new ArrayList<>(list));
            return;
        }
        if(target <0 || index >= nums.length){
            return;
        }

        //pick
        list.add(nums[index]);        
        helper(nums, target-nums[index], index, list);
        list.remove(list.size()-1);
        helper(nums, target, index+1, list);
    }
}
