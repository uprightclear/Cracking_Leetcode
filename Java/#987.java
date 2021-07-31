//DFS + 优先队列
class Solution {
    PriorityQueue<int[]> q = new PriorityQueue<>((a, b)->{ // col, row, val
        if (a[0] != b[0]) return a[0] - b[0];
        if (a[1] != b[1]) return a[1] - b[1];
        return a[2] - b[2];
    });
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        int[] info = new int[]{0, 0, root.val};
        q.add(info);
        dfs(root, info);
        List<List<Integer>> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            int[] poll = q.peek();
            while (!q.isEmpty() && q.peek()[0] == poll[0]) tmp.add(q.poll()[2]);
            ans.add(tmp);
        }
        return ans;
    }
    void dfs(TreeNode root, int[] fa) {
        if (root.left != null) {
            int[] linfo = new int[]{fa[0] - 1, fa[1] + 1, root.left.val};
            q.add(linfo);
            dfs(root.left, linfo);
        }
        if (root.right != null) {
            int[] rinfo = new int[]{fa[0] + 1, fa[1] + 1, root.right.val};
            q.add(rinfo);
            dfs(root.right, rinfo);
        }
    }
}


//DFS + HashMap + Sort
class Solution {
    Map<TreeNode, int[]> map = new HashMap<>(); // col, row, val
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        map.put(root, new int[]{0, 0, root.val});
        dfs(root);
        List<int[]> list = new ArrayList<>(map.values());
        Collections.sort(list, (a, b)->{
            //列不相同，按升序排列
            if (a[0] != b[0]) return a[0] - b[0];
            //行不相同，按升序排列
            if (a[1] != b[1]) return a[1] - b[1];
            //行列都相同，按值升序排列
            return a[2] - b[2];
        });
        int n = list.size();
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; ) {
            int j = i;
            List<Integer> tmp = new ArrayList<>();
            //同一列的所有值添加到tmp里
            while (j < n && list.get(j)[0] == list.get(i)[0]) tmp.add(list.get(j++)[2]);
            ans.add(tmp);
            i = j;
        }
        return ans;
    }
    void dfs(TreeNode root) {
        if (root == null) return ;
        int[] info = map.get(root);
        int col = info[0], row = info[1], val = info[2];
        if (root.left != null) {
            map.put(root.left, new int[]{col - 1, row + 1, root.left.val});
            dfs(root.left);
        }
        if (root.right != null) {
            map.put(root.right, new int[]{col + 1, row + 1, root.right.val});
            dfs(root.right);
        }
    }
}