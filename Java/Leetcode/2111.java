class Solution {
    public int kIncreasing(int[] arr, int k) {
        int result = 0;
        for (int i = 0; i < k; i++) {
           List<Integer> list = new ArrayList<>();
           for (int j = i; j < arr.length; j += k) list.add(arr[j]);
           result += increasing(list);
        }
       return result;
    }

    //we must use bs algo or the solution will be TLE
    private int increasing(List<Integer> nums) {
        // 将 nums 变成递增
        // nlogn 求 LIS
        int[] dp = new int[nums.size()];
        int len = 0;
        for (int num : nums) {
            int l = 0, r = len;
            while (l < r) {
                int mid = (l + r) / 2;
                if (dp[mid] <= num) { // 非严格递增，等于也可
                   l = mid + 1;
                } else {
                   r = mid;
                }
            }
            if (r >= len) {
                len++;
            }
            dp[r] = num;
        }
        return nums.size() - len;
    }
}