class Solution {
    public int maxSubarraySumCircular(int[] A) {
        int dp = A[0];      //初始化
        int max = dp;       //最大子序列和
        int sum = dp;       //整个数组的和

        //求最大子序列和，见53题
        for (int i = 1; i < A.length; i++) {
            sum += A[i];
            dp = A[i] + Math.max(dp, 0);
            max = Math.max(dp, max);
        }

        int min = 0;
        dp = A[0];
        //注意，这里的区间范围一定不能包含最后一位，（eg. 全负的数组会出错）
        for (int i = 1; i < A.length - 1; i++) {
            dp = A[i] + Math.min(0, dp);
            min = Math.min(dp, min);
        }

        return Math.max(sum - min, max);
    }
}


class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = nums[0];
        int curMinSum = nums[0], minSum = nums[0];
        int curMaxSum = nums[0], maxSum = nums[0];
        for(int i = 1; i < nums.length; i++){
            totalSum += nums[i];
            curMinSum = curMinSum < 0 ? curMinSum + nums[i] : nums[i];
            curMaxSum = curMaxSum > 0 ? curMaxSum + nums[i] : nums[i];
            minSum = Math.min(minSum, curMinSum);
            maxSum = Math.max(maxSum, curMaxSum);
        }
        if(maxSum < 0){ // maxSum < 0意味着全部数字都小于0, 此时totalSum就是minSum，totalSum - minSum = 0不可能是结果
            return maxSum;
        }
        return Math.max(maxSum, totalSum - minSum);
    }
}