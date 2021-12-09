class Solution {
    public int minimumDeletions(int[] nums) {
        int len = nums.length;
        if(len <= 2) return len;
        int min = 0, max = 0;
        for(int i = 1; i < len; i++) {
            if(nums[i] < nums[min]) min = i;
            if(nums[i] > nums[max]) max = i;
        }
        
        if(min > max) {
            int t = min;
            min = max;
            max = t;
        }
        
        int res = 0;
        int left = 0, right = nums.length - 1;
        if (min - left + 1 < right - max + 1) {
            res += min - left + 1; // 贪心，移除 min 需要更少的操作，先移除 min
            left = min + 1;
            res += Math.min(max - left + 1, right - max + 1); // 然后再移除 max
        } else {
            res += right - max + 1;
            right = max - 1;
            res += Math.min(min - left + 1, right - min + 1);

        }
        return res;
    }
}