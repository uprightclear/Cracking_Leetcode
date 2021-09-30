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


//BFS
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<TreeNode> layer = new LinkedList<TreeNode>();
        layer.offer(root);
        while(!layer.isEmpty()){
            int size = layer.size();
            for(int i = 0; i < size; i++) {
                TreeNode node = layer.poll();
                if(node.left != null) layer.offer(node.left);
                if(node.right != null) layer.offer(node.right);
                if(i == size - 1) ans.add(node.val);
            }
        }
        return ans;
    }
}

//DFS
class Solution {
    List<Integer> rightside = new ArrayList();
    
    public void helper(TreeNode node, int level) {
        if (level == rightside.size()) 
            rightside.add(node.val);
        //add right node firstly if right node is null then add the left node
        if (node.right != null) 
            helper(node.right, level + 1);  
        if (node.left != null) 
            helper(node.left, level + 1);
    }    
    
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return rightside;
        
        helper(root, 0);
        return rightside;
    }
}