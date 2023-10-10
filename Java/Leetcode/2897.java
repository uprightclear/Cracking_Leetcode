class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int count[] = new int[32];
        long res = 0, cur = 0, mod = 1000000007;
        for (int a : nums)
            for (int i = 0; i < 32; i++)
                if ((a & (1 << i)) != 0)
                    count[i]++;
        for (int j = 0; j < k; j++) {
            cur = 0;
            for (int i = 0; i < 32; i++) {
                if (count[i] > 0) {
                    count[i]--;
                    cur += 1 << i;
                }
            }
            res = (res + cur * cur % mod) % mod;
        }
        return (int)res;
    }
}

//https://leetcode.com/problems/apply-operations-on-array-to-maximize-sum-of-squares/solutions/4143971/java-c-python-count-bits/