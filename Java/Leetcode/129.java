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
    int ans = 0;
    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return ans;
    }
    
    private void dfs(TreeNode node, int sum) {
        sum = sum * 10 + node.val;
        if(node.left == null && node.right == null) {
            ans+= sum;
            return;
        }
        if(node.left != null) dfs(node.left, sum);
        if(node.right != null) dfs(node.right, sum);
    }
}