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
    double res = Integer.MIN_VALUE;
    public double maximumAverageSubtree(TreeNode root) {
        dfs(root);
        return res;
    }
    
    public int[] dfs(TreeNode root) {
        if(root == null) {
            return new int[]{0, 0};
        }
        int[] l = dfs(root.left);
        int[] r = dfs(root.right);
        
        int sum = l[0] + r[0] + root.val;
        int count = l[1] + r[1] + 1;
        res = Math.max(res, (sum * 1.0) / count);
        return new int[]{sum, count};
    }
}