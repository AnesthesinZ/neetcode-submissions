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

    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        dfs(root);
        return diameter;
    }

    private int dfs(TreeNode root) {

        if (root == null) {
            return 0;
        }

        // base case
        if (root.left == null && root.right == null) {
            return 1;
        }
        int leftLen = dfs(root.left);
        int rightLen = dfs(root.right);

        diameter = Math.max(leftLen + rightLen, diameter);
        return Math.max(leftLen, rightLen) + 1;
    }
}
