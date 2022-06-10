/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        int maxWidth = 0;
        queue.offer(new Pair<>(root, 0));
        
        while(queue.size() != 0) {
            Pair<TreeNode, Integer> head = queue.peek();
            
            Integer currLevelSize = queue.size();
            Pair<TreeNode, Integer> elem = null;
            for(int i = 0; i < currLevelSize; i++) {
                elem = queue.poll();
                TreeNode node = elem.getKey();
                if(node.left != null) {
                    queue.offer(new Pair<>(node.left, 2 * elem.getValue()));
                }
                if(node.right != null) {
                    queue.offer(new Pair<>(node.right, 2 * elem.getValue() + 1));
                }
            }
            
            maxWidth = Math.max(maxWidth, elem.getValue() - head.getValue() + 1);
        }
        return maxWidth;
    }
}


class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        return dfs(root, 0, 1, new ArrayList<Integer>(), new ArrayList<Integer>());
    }
    
    public int dfs(TreeNode root, int level, int order, List<Integer> start, List<Integer> end){
        if(root == null)return 0;
        if(start.size() == level){
            start.add(order); 
            end.add(order);
        }else end.set(level, order);
        int cur = end.get(level) - start.get(level) + 1;
        int left = dfs(root.left, level + 1, 2*order, start, end);
        int right = dfs(root.right, level + 1, 2*order + 1, start, end);
        return Math.max(cur, Math.max(left, right));
    }
}