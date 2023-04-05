public class Solution {
    public int minimizeArrayValue(int[] nums) {
        long sum = 0;
        long result = 0;
        for (int index = 0; index < nums.length; ++index) {
            sum += nums[index];
            result = Math.max(result, (sum + index) / (index + 1));
        }
        return (int) result;
    }
}

class Solution {
    static boolean check(int[] nums, int k) {
        long have = 0;//前方的数字还可以帮我们后方的大数承载多少数字
        for (int n : nums) {
            if (n <= k) {
                have += k - n;//较小数，可以算入承载量
            } else {
                if (have < n - k) return false;//承载不了了，该答案不可行
                else have -= (n - k);//减去承载量
            }
        }
        return true;
    }
    
    public int minimizeArrayValue(int[] nums) {
        int left = 0, right = 1000000000;
        while (left < right) {//二分答案，寻找最大值
            int mid = left + (right - left) / 2;
            if (check(nums, mid)) right = mid;
            else left = mid + 1;
        }
        return left;
    }
}