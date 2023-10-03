class Solution {
    public int minOperations(List<Integer> nums, int k) {
        int len = nums.size();
        Set<Integer> set = new HashSet<>();
        int ans = 0;
        for(int i = len - 1; i >= 0; i--) {
            ans++;
            if(nums.get(i) <= k) set.add(nums.get(i));
            if(set.size() == k) return ans;
        }
        return ans;
    }
}