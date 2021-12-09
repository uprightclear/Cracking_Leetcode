class Solution {
    public void wiggleSort(int[] nums) {
        int len = nums.length;
        int[] buckets = new int[5001];
        
        for(int num : nums) {
            buckets[num]++;
        }
        
        int maxindex = 0;
        int minindex = 0;
        if(len % 2 == 1) {//odd num
            maxindex = len - 2;
            minindex = len - 1;
        } else {//even num
            maxindex = len - 1;
            minindex = len - 2;
        }
        
        int maxLen = 5000;
        for(int i = 1; i <= maxindex; i += 2) {
            while(buckets[maxLen] == 0) maxLen--;
            nums[i] = maxLen;
            buckets[maxLen]--;
        }
        
        for(int i = 0; i <= minindex; i += 2) {
            while(buckets[maxLen] == 0) maxLen--;
            nums[i] = maxLen;
            buckets[maxLen]--;
        }
    }
}