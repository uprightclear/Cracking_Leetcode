class Solution {
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int ans = 0;
        for(int i = 0; i < nums.size(); i++) {
            if(countBit(i) == k) ans += nums.get(i);
        }
        return ans;
    }


    public int countBit(int num) {
        int ans = 0;
        while(num != 0) {
            ans++;
            num &= num - 1;
        }
        return ans;
    }
}