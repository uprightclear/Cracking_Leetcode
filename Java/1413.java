class Solution {
    public int minStartValue(int[] nums) {
        int tmp = 0;
        int min = Integer.MAX_VALUE;
        for(int num : nums) {
            tmp += num;
            min = Math.min(min, tmp);
        }
        
        return 1 - min > 0 ? 1 - min : 1;
    }
}