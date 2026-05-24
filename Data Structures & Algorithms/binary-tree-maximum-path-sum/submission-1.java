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

        if (root.left == null && root.right == null) {
            maxVal = Math.max(root.val, maxVal);
            return root.val;
        }

        Integer maxLeft = null;
        Integer maxRight = null;

        if (root.left != null) {
            maxLeft = dfs(root.left);
        }

        if (root.right != null) {
            maxRight = dfs(root.right);
        }

        int maxSide;
        int bothSum;

        if (maxLeft == null) {
            maxSide = maxRight;
            bothSum = maxRight;
        } else if (maxRight == null) {
            maxSide = maxLeft;
            bothSum = maxLeft;
        } else {
            maxSide = Math.max(maxLeft, maxRight);
            bothSum = maxLeft + maxRight;
        }

        maxVal = Math.max(maxSide, maxVal);
        maxVal = Math.max(root.val, maxVal);
        maxVal = Math.max(bothSum + root.val, maxVal);
        maxVal = Math.max(maxSide + root.val, maxVal);

        if (maxSide + root.val > root.val) {
            return maxSide + root.val;
        }
        return root.val;
    }
}
