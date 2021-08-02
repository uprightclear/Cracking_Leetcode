class Solution {
    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        boolean[] used = new boolean[len];
        dfs(nums, 0, len, used, path, res);
        return res;
    }

    public void dfs(int[] nums, int begin, int len, boolean[] used, Deque<Integer> path, List<List<Integer>> res){
        if(begin == len){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = 0; i < len; i++){
            if(used[i]) continue;
            used[i] = true;
            path.addLast(nums[i]);
            dfs(nums, begin + 1, len, used, path, res);
            path.removeLast();
            used[i] = false;
        }
    }
}