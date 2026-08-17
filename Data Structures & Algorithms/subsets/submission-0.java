class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        helper(nums, 0, new ArrayList<Integer>());
        return ans;
    }
    public void helper(int[] nums, int index, List<Integer> list){
        //base case
        if(index == nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }

        //pick
        list.add(nums[index]);
        helper(nums, index+1, list);

        //backtrack
        list.remove(list.size()-1);

        //not pick
        helper(nums, index+1, list);
    }
}
