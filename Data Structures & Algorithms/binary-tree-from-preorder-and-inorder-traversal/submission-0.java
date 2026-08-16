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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        return helper(map, preorder, inorder, 0, inorder.length-1, 0, preorder.length-1);
    }
    public TreeNode helper(Map<Integer, Integer> map, int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd){
        //base case
        if(preStart> preEnd || inStart> inEnd) return null;

        TreeNode curr = new TreeNode(preorder[preStart]);
        int pos = map.get(curr.val);
        int numsLeft = pos - inStart;

        curr.left = helper(map, preorder, inorder, preStart+1, preStart + numsLeft, inStart, pos-1);
        curr.right = helper(map, preorder, inorder, preStart+numsLeft+1, preEnd, pos+1, inEnd);

        return curr;
    }
}
