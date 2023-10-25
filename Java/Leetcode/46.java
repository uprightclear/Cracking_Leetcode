class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    int len;
    boolean[] used;
    public List<List<Integer>> permute(int[] nums) {
        len = nums.length;
        used = new boolean[len];
        dfs(nums, 0);
        return ans;
    }

    private void dfs(int[] nums, int index) {
        if(index == len) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for(int i = 0; i < len; i++) {
            if(used[i]) continue;
            used[i] = true;
            path.add(nums[i]);
            dfs(nums, index + 1);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}