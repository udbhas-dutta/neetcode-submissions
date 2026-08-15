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
    int ans = 0;
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        helper(root,k);
        return ans;
    }
    public void helper(TreeNode root, int k){
        TreeNode curr = root;
        while(curr != null){
            if(curr.left == null){
                count++;
                if(count== k) ans = curr.val;
                curr = curr.right;
            } else {
                TreeNode leftChild = curr.left;
                while(leftChild.right != null){
                    leftChild = leftChild.right;
                }
                leftChild.right = curr;
                TreeNode temp = curr;
                curr = curr.left;
                temp.left = null;
            }
        }
    }
}
