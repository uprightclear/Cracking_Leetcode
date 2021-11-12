class Solution {
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        if(len == 0) return 0;
        // if(len == 1) return nums[0] == val ? 0 : 1;
        int ptr = len - 1;
        int i = 0;
        while(i <= ptr) {
            if(nums[i] == val) {
                swap(nums, i, ptr--);
            } else {
                i++;
            }
        }
        if(ptr == len - 1) return nums[ptr] == val ? len - 1 : len;
        return nums[ptr + 1] == val ? ptr + 1 : len;
    }
    
    private void swap (int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}


class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
    }