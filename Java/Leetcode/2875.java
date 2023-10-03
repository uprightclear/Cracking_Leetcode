class Solution {
    public int minSizeSubarray(int[] nums, int target) {
        long sum = 0L, pre = 0L;
        for(int num : nums) sum += num;
        int len = nums.length, k = (int)(target / sum), res = len;
        target %= sum;
        if(target == 0) return k * len;

        Map<Long, Integer> dp = new HashMap<>();
        dp.put(0L, -1);

        for(int i = 0; i < 2 * len; i++) {
            pre += nums[i % len];
            if(dp.containsKey(pre - target)) {
                res = Math.min(res, i - dp.get(pre - target));
            }
            dp.put(pre, i);
        }

        return res < len ? res + k * len : -1;
    }
}