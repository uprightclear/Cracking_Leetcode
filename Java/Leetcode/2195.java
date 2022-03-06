class Solution {
    public long minimalKSum(int[] nums, int k) {
        Arrays.sort(nums);
        long res = 0;
        int last = 0;
        for(int num : nums) {
            if(last == num) continue;
            int cnt = Math.min(k, num - last - 1);
            k -= cnt;
            res += (long)(last + 1 + last + cnt) * cnt / 2;
            last = num;
            if(k == 0) break;
        }
        if(k > 0) res += (long)(last + 1 + last + k) * k / 2;
        return res;
    }
}