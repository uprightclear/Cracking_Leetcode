class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if(n < 3) return res;
        Deque<Integer> path = new ArrayDeque<>();
        dfs(k, n, 1, path, res);
        return res;
    }

    public void dfs(int k, int target, int begin, Deque<Integer> path, List<List<Integer>> res){
        if(target == 0 && k == 0){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i = begin; i <= 9; i++){
            if(target - i < 0 || k < 0) break;
            path.addLast(i);
            dfs(k - 1, target - i, i + 1, path, res);
            path.removeLast();
        }

    }
}