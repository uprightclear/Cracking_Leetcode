class Solution {
    public long subArrayRanges(int[] nums) {
        long ans = 0;
        for(int i = 0; i < nums.length; i++) {
            int min = nums[i];
            int max = nums[i];
            for(int j = i + 1; j < nums.length; j++) {
                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);
                ans += max - min;
            }
        }
        return ans;
    }
}

class Solution {
    public long subArrayRanges(int[] A) {
        int n = A.length, j, k;
        long res = 0;
        
        Stack<Integer> s = new Stack<>();
        
        //set A[j] as the min num
        for (int i = 0; i <= n; i++) {
            while (!s.isEmpty() && A[s.peek()] > (i == n ? Integer.MIN_VALUE : A[i])) {
                j = s.pop();
                k = s.isEmpty() ? -1 : s.peek();
                res -= (long)A[j] * (i - j) * (j - k);

            }
            s.push(i);
        }
        
        
        s.clear();
        //set A[j] as the max num
        for (int i = 0; i <= n; i++) {
            while (!s.isEmpty() && A[s.peek()] < (i == n ? Integer.MAX_VALUE : A[i])) {
                j = s.pop();
                k = s.isEmpty() ? -1 : s.peek();
                res += (long)A[j] * (i - j) * (j - k);

            }
            s.push(i);
        }
        return res;
    }
}