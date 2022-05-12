class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> tmp = new ArrayDeque<>();
        for(int i = 0; i <= nums.length; i++){
            dfs(nums, i, 0, tmp, res);  
        }
        return res;
    }
    //n：长度为n的数组 s：长度为n的数组中的起始位置
    public void dfs(int[] nums, int n, int s, Deque<Integer> tmp, List<List<Integer>> res){
        if(tmp.size() == n){
            res.add(new ArrayList<>(tmp));
            return;
        }
        for(int i = s; i < nums.length; i++){
            tmp.addLast(nums[i]);
            dfs(nums, n, i + 1, tmp, res);
            tmp.removeLast();  
        }
    }
}