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
    int count = 0;
    public int averageOfSubtree(TreeNode root) {
        postOrder(root);
        return count;
    }

    public int[] postOrder(TreeNode root) {
        if(root == null) return new int[]{0, 0};
        int[] left = postOrder(root.left);
        int[] right = postOrder(root.right);
        int nodeSum = left[0] + right[0] + root.val;
        int nodeCount = left[1] + right[1] + 1;
        if(root.val == nodeSum / nodeCount) count++;
        return new int[]{nodeSum, nodeCount};
    }
}