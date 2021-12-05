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
    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder start = new StringBuilder();
        StringBuilder dest = new StringBuilder();
        getDirections(root, startValue, start);
        getDirections(root, destValue, dest);
        int common = 0;
        while (common < Math.min(start.length(), dest.length()) && start.charAt(common) == dest.charAt(common)) {
            common++;
        }
        if (common > 0) {
            start.delete(0, common);
            dest.delete(0, common);
        }
        for (int i = 0; i < start.length(); i++) {
            start.setCharAt(i, 'U');
        }
        return start.append(dest).toString();
    }

    private boolean getDirections(TreeNode root, int value, StringBuilder sb) {
        if (root == null) {
            return false;
        }
        if (root.val == value) {
            return true;
        }
        int len = sb.length();
        sb.append('L');
        if (getDirections(root.left, value, sb)) {
            return true;
        }
        sb.delete(len, sb.length());
        sb.append('R');
        return getDirections(root.right, value, sb);
    }
}