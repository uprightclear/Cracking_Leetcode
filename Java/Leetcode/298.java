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
    int ans = 1;
    public int longestConsecutive(TreeNode root) {
        dfs(root.left, root.val, 1);
        dfs(root.right, root.val, 1);
        return ans;    
    }
    
    public void dfs(TreeNode node, int pre, int len) {
        if(node == null) return;
        if(node.val == pre + 1) {
            ans = Math.max(ans, ++len);
            dfs(node.left, node.val, len);
            dfs(node.right, node.val, len);
        } else {
            dfs(node.left, node.val, 1);
            dfs(node.right, node.val, 1);
        }
    }
}