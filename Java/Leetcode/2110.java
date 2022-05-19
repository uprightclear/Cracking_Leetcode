class Solution {
    public long getDescentPeriods(int[] prices) {
        long res = 0;
        for(int end = 0, start = 0; end < prices.length; end++) {
            if(end > 0 && prices[end] != prices[end - 1] - 1) start = end;
            res += end - start + 1;
        }
        return res;
    }
}