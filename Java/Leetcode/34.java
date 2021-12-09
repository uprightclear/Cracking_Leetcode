class Solution {
    public int[] searchRange(int[] nums, int target) {
        int index = binarySearch(nums, target);
        if(index == -1) return new int[]{-1, -1};
        int low = index - 1, high = index + 1;
        while(low >= 0 &&nums[low] == target) low--;
        while(high < nums.length && nums[high] == target) high++;
        return new int[]{low + 1, high - 1};
    }

    public int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
}


class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[]{-1, -1};
        int n = nums.length;
        if (n == 0) return ans;

        int l = 0, r = n - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        if (nums[l] != target) {
            return ans;
        } else {
            ans[0] = l;
            l = 0; r = n - 1;
            while (l < r) {
                //因为在找有边界，l + r + 1确保取中间值时取到的是更大值（偶数时取的是第二个mid）
                int mid = l + r + 1 >> 1;
                if (nums[mid] <= target) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            } 
            ans[1] = l;
            return ans;
        }
    }
}