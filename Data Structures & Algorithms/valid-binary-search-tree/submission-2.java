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
        return isValidBST(root, null, null);
    }

    public boolean isValidBST(TreeNode root, Integer leftBound, Integer rightBound) {
        if (root == null) {
            return true;
        }

        boolean l = leftBound == null ? true : root.val > leftBound;
        boolean r = rightBound == null ? true: root.val < rightBound;

        return l && r && 
            isValidBST(root.left, leftBound, root.val) && 
            isValidBST(root.right, root.val, rightBound);
    }
}
