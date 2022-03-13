class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> ans = new ArrayList<>();
        int last = -1;
        for(int j = 0; j < nums.length; j++) {
            if(nums[j] == key) {
                for(int i = Math.max(last + 1, j - k); i <= j + k && i < nums.length; i++) {
                    ans.add(i);
                    last = i;
                }
            }
        }
        return ans;
    }
}