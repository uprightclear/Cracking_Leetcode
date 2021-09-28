class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int len = nums.length;
        int end = len - 1;
        int begin = 0;
        while(begin < end) {
            if(nums[begin] % 2 == 1) {//put the odd number in the end
                swap(nums, begin, end);
                end--;
            }else {//even number in the begin
                begin++;
            }
        }
        
        for(int i = 1; i < len / 2; i += 2) {
            swap(nums, i, len - i - 1);
        }
        
        return nums;
    }
    
    private void swap(int[] nums, int l, int r) {
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
    }
}


class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int j = 1;
        for (int i = 0; i < A.length; i += 2)
            if (A[i] % 2 == 1) {
                while (A[j] % 2 == 1)
                    j += 2;

                // Swap A[i] and A[j]
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }

        return A;
    }
}