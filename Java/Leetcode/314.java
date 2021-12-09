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
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
        if(a[0] != b[0]) return a[0] - b[0];
        // if(a[1] != b[1]) 
        return a[1] - b[1];
        // return a[2] - b[2];
    });
    
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        int[] curInfo = new int[]{0, 1, root.val};
        pq.add(curInfo);
        dfs(root, 0, 1);
        while(!pq.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int[] cur = pq.peek();
            while(!pq.isEmpty() && pq.peek()[0] == cur[0]){
                temp.add(pq.poll()[2]);
            }
            res.add(new ArrayList<>(temp));
        }
        return res;
    }
    
    public void dfs(TreeNode node, int col, int index){
        if(node.left != null) {
            int[] leftInfo = new int[]{col - 1, 2 * index, node.left.val};
            pq.add(leftInfo);
            dfs(node.left, col - 1, 2 * index);
        }
        if(node.right != null) {
            int[] rightInfo = new int[]{col + 1, 2 * index + 1, node.right.val};
            pq.add(rightInfo);
            dfs(node.right, col + 1, 2 * index + 1);
        }
    }
}