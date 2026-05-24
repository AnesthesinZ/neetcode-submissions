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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inoderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inoderMap.put(inorder[i], i);
        }

        return buildTree(preorder, inorder, 0, 0,
                inorder.length - 1, 0, preorder.length - 1,
                inoderMap
        );
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, int rootIdx,
                              int inLeftBound, int inRightBound,
                              int preLeftBound, int preRightBound,
                              Map<Integer, Integer> inoderMap) {

        if (rootIdx > preRightBound || rootIdx < preLeftBound || preLeftBound > preRightBound) {
            return null;
        }

        int rootVal = preorder[rootIdx];
        TreeNode root = new TreeNode(rootVal);

        if (rootIdx == preLeftBound && rootIdx == preRightBound) {
            return root;
        }

        int inorderRootIdx = inoderMap.get(rootVal);

        int leftSize = inorderRootIdx - inLeftBound;

        int leftRootIdx = rootIdx + 1;
        int rightRootIdx = rootIdx + leftSize + 1;

        TreeNode leftTree =
                buildTree(preorder, inorder, leftRootIdx, inLeftBound, inorderRootIdx - 1, leftRootIdx, rightRootIdx - 1, inoderMap);

        TreeNode rightTree =
                buildTree(preorder, inorder, rightRootIdx, inorderRootIdx + 1, inRightBound, rightRootIdx, preRightBound, inoderMap);

        root.left = leftTree;
        root.right = rightTree;

        return root;
    }
}
