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
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return helper(root, p, q);
    }
    public TreeNode helper(TreeNode root, TreeNode a, TreeNode b){
        //base case
        if(root == null || root == a || root == b) return root;

        TreeNode left = helper(root.left, a, b);
        TreeNode right = helper(root.right, a, b);

        if(left == null) return right;
        else if(right == null) return left;
        
        //else, means none of left and right are null
        else return root;
    }
}
