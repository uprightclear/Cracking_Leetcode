class Solution {

    public int numberOfArithmeticSlices(int[] nums) {
        int len = nums.length;
        if (len < 3) {
            return 0;
        }

        // dp[i]：以 nums[i] 结尾，公差为 key 的等差数列的长度 - 1
        Map<Long, Integer>[] dp = new HashMap[len];
        for (int i = 0; i < len; i++) {
            dp[i] = new HashMap<>();
        }

        int res = 0;
        // 从 1 开始就可以
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                long diff = (long) nums[i] - nums[j];
                if (diff > Integer.MAX_VALUE || diff < Integer.MIN_VALUE) {
                    continue;
                }
                // dp[i][diff] += (dp[j][diff] + 1) ，Java 写起来有点麻烦，表示 nums[i] 可以接在之前「公差相等」的等差数列后面形成长度更长的等差数列
                dp[i].put(diff, dp[i].getOrDefault(diff, 0) + dp[j].getOrDefault(diff, 0) + 1);
                
                // 与之前的等差数列公差相等的时候，说明可以接上，此时计算结果
                if (dp[j].containsKey(diff)) {
                    // 理解：对结果的贡献「恰好是」之前的某个 j 的对应状态值，这里的 j 一定会在之前的某一个 i 加上 1，看上面有注释的那一行代码
                    res += dp[j].get(diff);
                }
            }
        }
        return res;
    }
}