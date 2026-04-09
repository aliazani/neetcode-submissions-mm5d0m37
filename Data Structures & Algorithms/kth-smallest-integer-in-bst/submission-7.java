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
    public int kthSmallest(TreeNode root, int k) {
        int counter = 0;
        List<TreeNode> list = new ArrayList<>();
        TreeNode curr = root;

        while (curr != null || !list.isEmpty()) {
            while (curr != null) {
                list.add(curr);
                curr = curr.left;
            }

            curr = list.removeLast();
            counter++;

            if (counter == k) return curr.val;

            curr = curr.right;
        }

        return 0;
    }
}