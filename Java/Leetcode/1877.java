class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int[] arr = new int[nums.length / 2];
        for(int i = 0; i < nums.length / 2; i++) {
            arr[i] = nums[i] + nums[nums.length - 1 - i];
        }
        Arrays.sort(arr);
        return arr[arr.length - 1];
    }
}

//more elegant
class Solution {
    public int minPairSum(int[] A) {
        Arrays.sort(A);
        int res = 0, n = A.length;
        for (int i = 0; i < n / 2; ++i)
            res = Math.max(res, A[i] + A[n - i - 1]);
        return res;
    }
}