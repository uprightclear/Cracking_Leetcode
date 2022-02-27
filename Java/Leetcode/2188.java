class Solution {
    public int minimumFinishTime(int[][] tires, int changeTime, int numLaps) {
        //g[i]: the min time to finish i laps without changint tire
        long[] g = new long[numLaps + 1];
        Arrays.fill(g, Long.MAX_VALUE);
        for(int[] t : tires) {
            long pn = 1, sum = t[0];
            for(int i = 1; i <= numLaps && sum < Integer.MAX_VALUE; i++) {
                g[i] = Math.min(g[i], sum);
                pn *= t[1];
                sum += t[0] * pn;
            }
        }
        
        //f[i]: the min time to finish i laps
        long[] f = new long[numLaps + 1];
        Arrays.fill(f, Long.MAX_VALUE);
        f[0] = 0;
        for(int i = 1; i <= numLaps; i++) {
            for(int j = 1; j <= i && g[j] < Integer.MAX_VALUE; j++) {
                f[i] = Math.min(f[i], f[i - j] + g[j] + changeTime);
            }
        }
        //since the car with tires to begin we should subtract extra 1 changeTime
        return (int) (f[numLaps] - changeTime);
    }
}