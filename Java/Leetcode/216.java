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

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        combination(ans, new ArrayList<Integer>(), k, 1, n);
        return ans;
    }

    private void combination(List<List<Integer>> ans, List<Integer> comb, int k,  int start, int n) {
        if (comb.size() == k && n == 0) {
            List<Integer> li = new ArrayList<Integer>(comb);
            ans.add(li);
            return;
        }
        for (int i = start; i <= 9; i++) {
            comb.add(i);
            combination(ans, comb, k, i+1, n-i);
            comb.remove(comb.size() - 1);
        }
    }
}