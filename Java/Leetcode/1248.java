class Solution {
    public int numberOfSubarrays(int[] A, int k) {
        return atMost(A, k) - atMost(A, k - 1);
    }

    public int atMost(int[] A, int k) {
        int res = 0, i = 0, n = A.length;
        for (int j = 0; j < n; j++) {
            k -= A[j] % 2;
            //if there are more than k odd num, move forward index i;
            while (k < 0)
                k += A[i++] % 2;
            res += j - i + 1;
        }
        return res;
    }
}

class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int start = -1, first_odd = 0;
        int ans = 0;
        for(int num : nums) {
            k -= num % 2;
            if(nums[first_odd] % 2 == 0) first_odd++;
            if(k < 0) start = first_odd;
            while(k < 0) {
                first_odd++;
                k += nums[first_odd] % 2;
            }
            if(k == 0) ans += first_odd - start;
        }
        return ans;
    }
}