class Solution {
    public int totalMoney(int n) {
        int week = 1, day = 1;
        int res = 0;
        for (int i = 0; i < n; ++i) {
            res += week + day - 1;
            ++day;
            if (day == 8) {
                day = 1;
                ++week;
            }
        }
        return res;
    }
}