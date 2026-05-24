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

    int res = -1;

    public int kthSmallest(TreeNode root, int k) {
        visit(root, 0, k);
        return res;
    }

    public int visit(TreeNode root, int prevCount, int target) {
        if (root == null) {
            return prevCount;
        }

        int leftCount = visit(root.left, prevCount, target);

        if (leftCount + 1 == target) {
            this.res = root.val;
        }

        int rightCount = visit(root.right, leftCount + 1, target);

        // if (rightCount == target && root.right != null) {
        //     this.res = root.right.val;
        // }

        return rightCount;
    }
}
