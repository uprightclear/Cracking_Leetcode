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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> layer = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        layer.offer(root);
        while(!layer.isEmpty()){
            int size = layer.size();
            List<Integer> tmp = new ArrayList<>();
            while(size-- > 0){
                TreeNode p = layer.poll();
                if(p.left != null) layer.offer(p.left);
                if(p.right != null) layer.offer(p.right);
                tmp.add(p.val);
            }
            res.add(tmp);
        }
        return res;
    }
}