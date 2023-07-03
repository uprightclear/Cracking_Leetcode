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
    int max = 0;
    public int longestZigZag(TreeNode root) {
        path(root.left, 0, false);
        path(root.right, 0, true);
        return max;
    }
    
    public void path(TreeNode node, int depth, boolean direction) { // true: right. false: left
        max = Math.max(max, depth);
        if(node == null) return;
        path(node.left, direction ? depth + 1 : 0, false);
        path(node.right, direction ? 0 : depth + 1, true);
    }
}