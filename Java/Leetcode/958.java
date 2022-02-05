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
//recursion
class Solution {
    public boolean isCompleteTree(TreeNode root) {
        return isCompleteTree(root,0,countNodes(root));
    }
    private boolean isCompleteTree(TreeNode root, int i, int n) { 
        if (root == null)  return true; 
        else if (i >= n) return false; 
        return isCompleteTree(root.left, 2 * i + 1, n) && isCompleteTree(root.right, 2 * i + 2, n); 
    } 
    private  int countNodes(TreeNode root) { 
        if (root == null) return 0; 
        return 1 + countNodes(root.left) + countNodes(root.right); 
    } 
}

//bfs
class Solution {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> bfs = new LinkedList<TreeNode>();
        bfs.offer(root);
        while (bfs.peek() != null) {
            TreeNode node = bfs.poll();
            bfs.offer(node.left);
            bfs.offer(node.right);
        }
        while (!bfs.isEmpty() && bfs.peek() == null)
            bfs.poll();
        return bfs.isEmpty();
    }
}