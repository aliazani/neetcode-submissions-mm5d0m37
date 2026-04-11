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

public class Codec {

    // Serialize: convert tree to string
    public String serialize(TreeNode root) {
        StringBuilder result = new StringBuilder();
        dfsSerialize(root, result);
        return result.toString();
    }

    private void dfsSerialize(TreeNode node, StringBuilder result) {
        if (node == null) {
            result.append("N,");
            return;
        }

        result.append(node.val).append(",");
        dfsSerialize(node.left, result);
        dfsSerialize(node.right, result);
    }

    // Deserialize: convert string back to tree
    public TreeNode deserialize(String data) {
        String[] values = data.split(",");
        int[] index = {0}; // use array to simulate pass-by-reference
        return dfsDeserialize(values, index);
    }

    private TreeNode dfsDeserialize(String[] values, int[] index) {
        // Base case: null node
        if (values[index[0]].equals("N")) {
            index[0]++;
            return null;
        }

        // Create node
        TreeNode node = new TreeNode(Integer.parseInt(values[index[0]]));
        index[0]++;

        // Build left and right
        node.left = dfsDeserialize(values, index);
        node.right = dfsDeserialize(values, index);

        return node;
    }
}