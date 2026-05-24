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

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();

        if (root == null) {
            return "";
        }

        q.add(root);

        while (!q.isEmpty()) {
            TreeNode n = q.poll();

            if (n == null) {
                sb.append("null,");
            } else {
                q.add(n.left);
                q.add(n.right);

                sb.append(n.val);
                sb.append(',');
            }

        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        if (data.length() == 0) {
            return null;
        }

        String[] nodes = data.split(",");

        Queue<TreeNode> q = new LinkedList<>();



        TreeNode root = new TreeNode(Integer.valueOf(nodes[0]));
        q.add(root);
        int i = 1;

        while (!q.isEmpty()) {
            TreeNode n = q.poll();

            for (int idx = i; idx < i+2 && idx < nodes.length; idx++) {
                if (!nodes[idx].equals("null")) {
                    TreeNode nl = new TreeNode(Integer.valueOf(nodes[idx]));
                    if (idx == i) {
                        n.left = nl;
                    } else {
                        n.right = nl;
                    }
                    q.add(nl);
                }
            }
            i+=2;
        }
        return root;
    }
}
