//https://leetcode.com/problems/broken-calculator/discuss/234484/JavaC%2B%2BPython-Change-Y-to-X-in-1-Line
class Solution {
    public int brokenCalc(int startValue, int target) {
        int res = 0;
        while (target > startValue) {
            target = target % 2 > 0 ? target + 1 : target / 2;
            res++;
        }
        return res + startValue - target;
    }
}