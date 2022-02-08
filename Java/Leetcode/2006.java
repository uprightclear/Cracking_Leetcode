class Solution {
    public int countKDifference(int[] nums, int k) {
        int ans = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        for(int num : nums) cnt.put(num, cnt.getOrDefault(num, 0) + 1);
        for(int num : nums) ans += cnt.getOrDefault(num - k, 0);
        return ans;
    }
}