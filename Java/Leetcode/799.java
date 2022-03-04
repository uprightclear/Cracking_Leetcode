class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        //add two guard points to prevent exceed
        double[] res = new double[query_row + 2];
        res[0] = poured;
        for (int row = 1; row <= query_row; row++)
            //the reason why it should iterate from end to start is that the res[i + 1] depends on res[i] so we cannot change the former
            for (int i = row; i >= 0; i--)
                res[i + 1] += res[i] = Math.max(0.0, (res[i] - 1) / 2);
        return Math.min(res[query_glass], 1.0);
    }
}