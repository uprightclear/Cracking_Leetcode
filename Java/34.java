class Solution {
    public int[] searchRange(int[] nums, int target) {

        int l = 0, r = nums.length - 1;
        int start = -2,end = 0;
        while(l <= r) {
            //获取中间下标
            int mid = (l + r) / 2;
            //若中间的数比target小，从右边找
            if(nums[mid] < target) {
                l = mid + 1;
            } else if(nums[mid] > target) {//否则，从左边开始找
                r = mid - 1;
            } else {
                //令start和end都等于mid
                start = mid;
                end = mid;
                //只要start和end满足边界条件，并且等于target值，都可以进行循环
                while(start >= 0 && nums[start] == target)
                    start --;
                while(end < nums.length && nums[end] == target)
                    end ++;
                break;
            }
        }
        //由于循环出来之后nums[start] != target nums[end] != target，所以需要start+1，end-1
        return new int[]{start + 1, end - 1};
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