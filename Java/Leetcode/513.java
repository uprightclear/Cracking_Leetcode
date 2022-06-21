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
    public int findBottomLeftValue(TreeNode root) {
        int ans = root.val;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            int size = q.size();
            ans = q.peek().val;
            while(size-- > 0) {
                TreeNode cur = q.poll();
                if(cur.left != null) q.offer(cur.left);
                if(cur.right != null) q.offer(cur.right);
            }
        }
        return ans;
    }
}