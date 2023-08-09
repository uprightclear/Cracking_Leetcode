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
    public TreeNode replaceValueInTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int ans = root.val;
        while(!q.isEmpty()) {
            int layer = 0, size = q.size();
            for(int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                cur.val = ans - cur.val;
                if(cur.left != null) {
                    q.offer(cur.left);
                    layer += cur.left.val;
                }
                if(cur.right != null) {
                    q.offer(cur.right);
                    layer += cur.right.val;
                }
                if(cur.left != null && cur.right != null) {
                    int x = cur.left.val + cur.right.val;
                    cur.left.val = x;
                    cur.right.val = x;
                }
            }
            ans = layer;
        }
        return root;
    }
}