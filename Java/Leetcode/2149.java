class Solution {
    public int[] rearrangeArray(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        Queue<Integer> pos = new LinkedList<>();
        Queue<Integer> neg = new LinkedList<>();
        for(int num : nums) {
            if(num > 0) pos.offer(num);
            else neg.offer(num);
        }
        for(int i = 0; i < len; i++) {
            if(i % 2 == 0) ans[i] = pos.poll();
            else ans[i] = neg.poll();
        }
        return ans;
    }
}

//2 pointers
class Solution {
    public int[] rearrangeArray(int[] nums) {
        int [] out = new int [nums.length];
        int j = 0;
        int k = 1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] >= 0){
                out[j] = nums[i];
                j += 2;
            }else {
                out[k] = nums[i];
                k += 2;
            }
        }
        return out;
    }
}