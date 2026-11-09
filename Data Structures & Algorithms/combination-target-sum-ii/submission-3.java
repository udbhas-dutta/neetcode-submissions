class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        helper(candidates, target, new ArrayList<>(), 0);
        return ans;
    }
    public void helper(int[] nums, int target, List<Integer> list, int index){
        //base case
        if(target == 0){
            ans.add(new ArrayList<>(list));
            return;
        }

        for(int i = index; i<nums.length; i++){
            if(i>index && nums[i] == nums[i-1]) continue;
            if(nums[i] > target) break;

            list.add(nums[i]);
            helper(nums, target-nums[i], list, i+1);
            list.remove(list.size()-1);
        }
    }
}
