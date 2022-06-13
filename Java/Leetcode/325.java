class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int pre = 0, ans = 0;
        for(int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if(map.containsKey(pre - k)) {
                ans = Math.max(ans, i - map.get(pre - k));
            }
            if(!map.containsKey(pre)) map.put(pre, i);
        }
        return ans;
    }
}