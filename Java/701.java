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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            // root == null 为终止条件，此时新建结点，并返回插入
            return new TreeNode(val);
        }
        if(root.val < val){
            // val 比root值大，对右子树结点进行递归操作
            root.right = insertIntoBST(root.right, val);
        }else{
            // val 比root值小，对左子树结点进行递归操作
            root.left = insertIntoBST(root.left, val);
        }
        // 向上层返回已经完成插入操作的结点
        return root;
    }
}