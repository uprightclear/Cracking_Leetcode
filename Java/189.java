//使用额外数组
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] newArr = new int[n];
        for (int i = 0; i < n; ++i) {
            newArr[(i + k) % n] = nums[i];
        }
        System.arraycopy(newArr, 0, nums, 0, n);
    }
}


//环状替换   gcd：最大公约数
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int count = gcd(k, n);
        for (int start = 0; start < count; ++start) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % n;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
            } while (start != current);
        }
    }
    //求最大公约数
    public int gcd(int x, int y) {
        return y > 0 ? gcd(y, x % y) : x;
    }
}


//数组翻转
class Solution {
    public void rotate(int[] nums, int k) {
        int m = k % nums.length;
        if(m != 0) {
            swap(nums, 0, nums.length - 1);
            swap(nums, 0, m - 1);
            swap(nums, m, nums.length - 1); 
        }
    }
    
    private void swap(int[] nums, int l, int r) {
        while(l < r) {
            int tmp = nums[l];
            nums[l++] = nums[r];
            nums[r--] = tmp;
        }
    }
}