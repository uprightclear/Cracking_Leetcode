//排序
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int[] newnums = nums.clone();
        Arrays.sort(newnums);
        int i=0,j= n-1;
        while(i < n && nums[i] == newnums[i]) ++i;
        while(j > i && nums[j] == newnums[j]) --j;
        return j-i+1;
    }
}

//一次遍历
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int maxn = Integer.MIN_VALUE, right = -1;
        int minn = Integer.MAX_VALUE, left = -1;
        for (int i = 0; i < n; i++) {
            if (maxn > nums[i]) {
                right = i;
            } else {
                maxn = nums[i];
            }
            if (minn < nums[n - i - 1]) {
                left = n - i - 1;
            } else {
                minn = nums[n - i - 1];
            }
        }
        return right == -1 ? 0 : right - left + 1;
    }
}