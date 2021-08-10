//DFS
class Solution {
    private int total = 0;
    private int Maxdeep = -1;
    public int deepestLeavesSum(TreeNode root) {
        dfs(root, 0);
        return total;
    }
    private void dfs(TreeNode node, int deep){
        if(node == null) return;
        deep++;
        if(deep > Maxdeep){
            Maxdeep = deep;
            total = node.val;
        }
        else if(deep == Maxdeep) total += node.val;
        dfs(node.left, deep);
        dfs(node.right, deep);
    }
}

//BFS
class Solution{
    public int deepestLeavesSum(TreeNode root) {
        return bfs(root);
    }

    //广度优先搜索（层序遍历）
    public int bfs(TreeNode root){
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int sumOfLeaf = 0;
        while(!queue.isEmpty()){
            sumOfLeaf = 0;
            int size = queue.size();
            TreeNode node;
            //更新当前层的叶子和（最终得到的就是最底层的叶子和）
            while(size-- > 0){
                node = queue.poll();
                sumOfLeaf += node.val;
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
        }
        return sumOfLeaf;
    }
}