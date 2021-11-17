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
    List<String> ans = new LinkedList<>();
    
    public List<String> binaryTreePaths(TreeNode root) {
        dfs(root, "");
        return ans;
    }
    
    public void dfs(TreeNode root, String path) {
        if(root != null) {
            path += Integer.toString(root.val);
            if(root.left == null && root.right == null) ans.add(path);
            else {
                path += "->";
                dfs(root.left, path);
                dfs(root.right, path);
            }
        }
    }
}