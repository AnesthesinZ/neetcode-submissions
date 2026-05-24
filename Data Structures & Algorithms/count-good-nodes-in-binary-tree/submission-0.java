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
    public int goodNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return dfs(root, root.val);
    }


    private int dfs(TreeNode root, int pathMax) {

        if (root == null) {
            return 0;
        }

        int curMax = Math.max(root.val, pathMax);
        
        return dfs(root.left, curMax) + dfs(root.right, curMax) + (root.val >= curMax ? 1 : 0);
    }

}
