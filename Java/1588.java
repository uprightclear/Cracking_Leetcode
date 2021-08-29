class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int n = arr.length;
        int[] presum = new int[n + 1];
        presum[0] = 0;
        //前i个数的和（从1开始）
        for(int i = 0; i < n; i++){
            presum[i + 1] = presum[i] + arr[i]; 
        } 

        int res = 0;
        //枚举所有可能的奇数长度子数组
        for(int i = 0; i < n; i++){
            for(int size = 1; i + size - 1 < n; size += 2){
                res += presum[i + size] - presum[i];
            }
        }
        return res;
    }
}


class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int n = arr.length;
        int res = 0;
        for(int i = 0; i < n; i++){
            //下标i左右两边可选的前缀和后缀长度分别为i + 1，n - i。
            int left = i + 1, right = n - i;
            //为保证总的子数组长度为奇数，有两种情况可选择：1、前缀长度和后缀长度均为偶数 2、前缀长度和后缀长度均为奇数
            //（加上下标i元素本身可保证子数组长度为奇数）
            int left_even = (left + 1) / 2, right_even = (right + 1) / 2;
            int left_odd = left / 2, right_odd = right / 2;
            //下标为i的元素在不同情况的子数组中出现，将其累加
            res += (left_even * right_even + left_odd * right_odd) * arr[i];
        }
        return res;
    }
}