class Solution {
    public int minCostToMoveChips(int[] position) {
        int even_cnt = 0;
        int odd_cnt = 0;
        for (int i : position) {
            if (i % 2 == 0) {
                //put all the even to the odd position
                even_cnt++;
            } else {
                //put all the odd to the even position
                odd_cnt++;
            }
        }
        return Math.min(odd_cnt, even_cnt);
    }
}