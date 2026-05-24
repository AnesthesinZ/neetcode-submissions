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

    int maxVal = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return this.maxVal;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftPath = Math.max(dfs(root.left), 0);
        int rightPath = Math.max(dfs(root.right), 0);

        int totalPath = leftPath + rightPath + root.val;

        this.maxVal = Math.max(totalPath, maxVal);

        return Math.max(leftPath, rightPath) + root.val;

    }
}
