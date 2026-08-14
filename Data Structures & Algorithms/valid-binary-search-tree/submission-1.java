/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    boolean ans = true;
    public boolean isValidBST(TreeNode root) {
        helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return ans;
    }
    public void helper(TreeNode root, int min, int max){
        //base case
        if(root == null) return;

        if(root.val <= min || root.val >= max) ans = false;
        helper(root.left, min, root.val);
        helper(root.right, root.val, max);
    }
}
