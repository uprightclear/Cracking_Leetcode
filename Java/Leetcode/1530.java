class Solution {
    public int countPairs(TreeNode root, int distance) {
        Pair pair = dfs(root, distance);
        return pair.count;
    }

    // 对于 dfs(root,distance)，同时返回：
    // 1）每个叶子节点与 root 之间的距离
    // 2) 以 root 为根节点的子树中好叶子节点对的数量
    public Pair dfs(TreeNode root, int distance) {
        int[] depths = new int[distance + 1];
        boolean isLeaf = root.left == null && root.right == null;
        if (isLeaf) { 
            depths[0] = 1;
            return new Pair(depths, 0);
        }

        int[] leftDepths = new int[distance + 1];
        int[] rightDepths = new int[distance + 1];
        int leftCount = 0, rightCount = 0;
        if (root.left != null) {
            Pair leftPair = dfs(root.left, distance);
            leftDepths = leftPair.depths;
            leftCount = leftPair.count;
        }
        if (root.right != null) {
            Pair rightPair = dfs(root.right, distance);
            rightDepths = rightPair.depths;
            rightCount = rightPair.count;
        }

        for (int i = 0; i < distance; i++) {
            depths[i + 1] += leftDepths[i];
            depths[i + 1] += rightDepths[i];
        }

        int cnt = 0;
        for (int i = 0; i <= distance; i++) {
            for (int j = 0; j + i + 2 <= distance; j++) {
                cnt += leftDepths[i] * rightDepths[j];
            }
        }
        return new Pair(depths, cnt + leftCount + rightCount);
    }
}

class Pair {
    int[] depths;
    int count;

    public Pair(int[] depths, int count) {
        this.depths = depths;
        this.count = count;
    }
}


class Solution {
    HashMap<TreeNode, ArrayList<TreeNode>> hash = new HashMap<>();
    List<TreeNode> leaf = new ArrayList<>();
    int count = 0; 
    public int countPairs(TreeNode root, int distance) {
        graph(root, null);
        for(TreeNode t: leaf){
            HashSet<TreeNode> visited = new HashSet<>();
            visited.add(t);
            check(t, hash, distance, visited);
        }
        
        return count/2;
        
    }
    
    public void check(TreeNode t, HashMap<TreeNode, ArrayList<TreeNode>> hash, int d, HashSet<TreeNode> visit){
        if(d <= 0 || t == null) return;
        for(TreeNode k: hash.get(t)){
             if(visit.contains(k)) continue;
             visit.add(k);
             if(leaf.contains(k)) count++;
             check(k, hash, d-1, visit);
             //visit.remove(k);
        }
    }
    
    
    public void graph(TreeNode root, TreeNode parent){
        if(root == null) return;
        if(hash.get(root) == null){
            hash.put(root, new ArrayList<TreeNode>());
        }
        ArrayList<TreeNode> li = hash.get(root);
        if(root.left !=null) li.add(root.left);
        if(root.right!=null) li.add(root.right);
        if(parent!=null) li.add(parent);
        if(root.left == null && root.right == null) leaf.add(root);
        graph(root.left, root);
        graph(root.right, root);
            
        }
        
    }