class Solution {
    public int minOperations(int[] nums, int x) {
        int current = 0;
        for (int num : nums) {
            current += num;
        }
        int n = nums.length;
        int mini = Integer.MAX_VALUE;
        int left = 0;

        for (int right = 0; right < n; right++) {
            // sum([0,..,left) + (right,...,n-1]) = x
            current -= nums[right];
            // if smaller, move `left` to left
            while (current < x && left <= right) {
                current += nums[left];
                left += 1;
            }
            // check if equal
            if (current == x) {
                mini = Math.min(mini, (n-1-right)+left);
            }
        }
        return mini != Integer.MAX_VALUE ? mini : -1;
    }
}


class Solution {
    public int minOperations(int[] nums, int x) {
        int target = Arrays.stream(nums).sum() - x, size = -1, n = nums.length;
        for (int lo = -1, hi = 0, winSum = 0; hi < n; ++hi) {
            winSum += nums[hi];
            while (lo + 1 < nums.length && winSum > target) {
                winSum -= nums[++lo];
            }
            if (winSum == target) {
                size = Math.max(size, hi - lo);
            }
        }
        return size < 0 ? -1 : n - size;
    }
}