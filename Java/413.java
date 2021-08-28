class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 0;
        }

        int d = nums[0] - nums[1], t = 0;
        int ans = 0;
        // 因为等差数列的长度至少为 3，所以可以从 i=2 开始枚举
        for (int i = 2; i < n; ++i) {
            if (nums[i - 1] - nums[i] == d) {
                ++t;
            } else {
                d = nums[i - 1] - nums[i];
                t = 0;
            }
            ans += t;
        }
        return ans;
    }
}

//双指针
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n - 2; ) {
            int j = i, d = nums[i + 1] - nums[i];
            while (j + 1 < n && nums[j + 1] - nums[j] == d) j++;
            int len = j - i + 1;
            // a1：长度为 len 的子数组数量；an：长度为 3 的子数组数量
            int a1 = 1, an = len - 3 + 1;
            // 符合条件（长度大于等于3）的子数组的数量为「差值数列求和」结果
            int cnt = (a1 + an) * an / 2;
            ans += cnt;
            i = j;
        }
        return ans;
    }
}

//DP
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int len = nums.length;
        if (len < 3) {
            return 0;
        }
        
        // dp[i] 表示以：nums[i] 结尾的、且长度大于等于 3 的连续等差数列的个数
        int[] dp = new int[len];
        int res = 0;
        // 从下标 2 开始，才有可能构成长度至少大于等于 3 的等差数列
        for (int i = 2; i < len; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                dp[i] = dp[i - 1] + 1;
                res += dp[i];
            }
        }
        return res;
    }
}