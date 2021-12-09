//Time Limit Exceeded
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int sum;
        for(int i = 0; i < nums.length - 1; i++) {
            sum = nums[i];
            for(int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if(sum % k == 0) return true;
            }
        }
        return false;
    }
}

//prefix + HashSet
//https://leetcode-cn.com/problems/continuous-subarray-sum/solution/gong-shui-san-xie-tuo-zhan-wei-qiu-fang-1juse/
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) sum[i] = sum[i - 1] + nums[i - 1];
        Set<Integer> set = new HashSet<>();
        for (int i = 2; i <= n; i++) {
            set.add(sum[i - 2] % k);
            if (set.contains(sum[i] % k)) return true;
        }
        return false;
    }
}