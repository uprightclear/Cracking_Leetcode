class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int[] preSum = new int[fruits.length];
        preSum[0] = fruits[0][1];
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + fruits[i][1];
       }
 
        // 1. 一直往左走
        // 2. 一直往右走
        // 3. 往左走到某个点折返，然后一直往右走
        // 4. 往右走到某个点折返，然后一直往左走
        int result = 0;
        for (int i = 0; i < fruits.length; i++) {
            if (k < Math.abs(startPos - fruits[i][0])) {
                continue;
           }
            // 折返点是 i
            result = Math.max(result, maxTotalFruitsStraight(fruits, preSum, i, k - Math.abs(startPos - fruits[i][0])));
       }
        return result;
   }
 
    int maxTotalFruitsStraight(int[][] fruits, int[] preSum, int startIdx, int k) {
        // 1. 一直往左走
        int step = 1, idx = startIdx;
        while (step > 0) {
            if (idx - step < 0 || k < fruits[startIdx][0] - fruits[idx - step][0]) {
                step /= 2;
                continue;
           }
            idx -= step;
            step *= 2;
       }
        int allLeft = preSum[startIdx];
        if (idx > 0) {
            allLeft -= preSum[idx - 1];
       }
        // 2. 一直往右走
        step = 1;
        idx = startIdx;
        while (step > 0) {
            if (idx + step >= fruits.length || k < fruits[idx + step][0] - fruits[startIdx][0]) {
                step /= 2;
                continue;
           }
            idx += step;
            step *= 2;
       }
        int allRight = preSum[idx];
        if (startIdx > 0) {
            allRight -= preSum[startIdx - 1];
       }
        return Math.max(allLeft, allRight);
   }
 }



 class Solution {
    public int maxTotalFruits(int[][] f, int pos, int k) {
        int l = 0, sum = 0, max_sum = 0;
        while (l < f.length && f[l][0] < pos - k)
            ++l;
        for (int r = l; r < f.length && f[r][0] <= pos + k; ++r) {
            sum += f[r][1];
            while(Math.min(pos - 2 * f[l][0] + f[r][0], 2 * f[r][0] - f[l][0] - pos) > k)
                sum -= f[l++][1];
            max_sum = Math.max(max_sum, sum);
        }
        return max_sum;
    }
}