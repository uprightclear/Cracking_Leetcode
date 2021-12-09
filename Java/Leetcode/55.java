public class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int rightmost = 0;
        for (int i = 0; i < n; ++i) {
            if (i <= rightmost) {
                rightmost = Math.max(rightmost, i + nums[i]);
                if (rightmost >= n - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}

//DP
// 能否到达终点,就看它的：
// - 前一个位置的数是不是大于1
// - 或者：前两个位置的数是不是大于2
// - 或者：前三个位置的数是不是大于3
// - 或者：……………………（类推）
// - 也就是nums[i] >= end - i这行代码。
class Solution {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        int end = len - 1;
        for (int i = len - 2; i >= 0 ; i--) {
            if (nums[i] >= end - i) {
                end = i;
            }
        }
        return end == 0;
    }
}