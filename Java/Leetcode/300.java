class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        int res = 1;
        for(int i = 1; i < len; i++) {
            for(int j = i - 1; j >= 0; j--) {
                if(nums[i] > nums[j]) dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}


//binary seach (https://leetcode-cn.com/problems/longest-increasing-subsequence/solution/zui-chang-shang-sheng-zi-xu-lie-by-leetcode-soluti/)
class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = 0;
        //dp[i]: the max end num of subsequence with length i + 1
        int[] dp = new int[nums.length];
        for(int num : nums) {
            int l = 0, r = len;
            //find the pos to intersect(same as #35)
            while(l < r) {
                int mid = (l + r) / 2;
                if(dp[mid] < num) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            if(l >= len) len++;
            dp[l] = num;
        }
        return len;
    }
}





//longest non-decreasing subsequence
class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = 0;
        int[] dp = new int[nums.length];
        for(int num : nums) {
            int l = 0, r = len;
            while(l < r) {
                int mid = (l + r) / 2;
                if(dp[mid] <= num) l = mid + 1;
                else r = mid;
            }
            if(l >= len) len++;
            dp[l] = num;
        }
        return len;
    }
}