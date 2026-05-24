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

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        }

        if (root == null) {
            return false;
        }

        if (sameTree(root, subRoot)) {
            return true;
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);

    }

    public boolean sameTree(TreeNode root, TreeNode sub) {
        if(root == null && sub == null) {
            return true;
        }

        if (root != null && sub == null) {
            return false;
        }

        if (root == null && sub != null) {
            return false;
        }

        return sameTree(root.left, sub.left) &&
            sameTree(root.right, sub.right) &&
            root.val == sub.val;
    }
}
