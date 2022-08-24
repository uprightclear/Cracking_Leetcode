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
    List<Integer> list;
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        list = new ArrayList<>();
        list.add(root.val);
        addLeft(root.left);
        addLeaves(root.left);
        addLeaves(root.right);
        addRight(root.right);
        return list;
    }
    
    public void addLeft(TreeNode node) {
        if(node == null) return;
        if(node.left != null) {
            list.add(node.val);
            addLeft(node.left);
        }else if (node.right != null) {
            list.add(node.val);
            addLeft(node.right);
        }
    }
    
    public void addLeaves(TreeNode node) {
        if(node == null) return;
        addLeaves(node.left);
        if(node.left == null && node.right == null) list.add(node.val);
        addLeaves(node.right);
    }
    
    public void addRight(TreeNode node) {
        if(node == null) return;
        if(node.right != null) {
            addRight(node.right);
            list.add(node.val);
        }else if (node.left != null) {
            addRight(node.left);
            list.add(node.val);
        }
    }
}