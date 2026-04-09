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
    public boolean isValidBST(TreeNode root) {
        // o(n) time and space
        return isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isValid(TreeNode node, int left, int right) {
    if (node == null) return true;
    if (node.val >= right || node.val <= left) return false;

    // left part: right < node.left < node.val
    // right part: node.val < node.right < right
    return isValid(node.left, left, node.val) && 
           isValid(node.right, node.val, right);
    }   
}
