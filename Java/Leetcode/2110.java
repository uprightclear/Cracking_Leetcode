class Solution {
    public long getDescentPeriods(int[] prices) {
        long res = 0;
        for(int i = 0, j = 0; i < prices.length; i++) {
            if(i > 0 && prices[i] != prices[i - 1] - 1) j = i;
            res += i - j + 1;
        }
        return res;
    }
}