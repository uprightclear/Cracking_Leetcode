class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> tmp = new ArrayDeque<>();
        Arrays.sort(nums);
        for(int i = 0; i <= nums.length; i++){
            dfs(nums, i, 0, tmp, res);
        }
        return res;
    }

    public void dfs(int[] nums, int n, int begin, Deque<Integer> tmp, List<List<Integer>> res){
        if(n == tmp.size()){
            res.add(new ArrayList<>(tmp));
            return;
        }
        for(int i = begin; i < nums.length; i++){
            if(i > begin && nums[i] == nums[i - 1]) continue;
            tmp.addLast(nums[i]);
            dfs(nums, n, i + 1, tmp, res);
            tmp.removeLast();
        }
    }
}