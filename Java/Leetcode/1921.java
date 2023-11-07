class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        double[] arrival = new double[dist.length];
        for (int i = 0; i < dist.length; i++) {
            arrival[i] = (double) dist[i] / speed[i];
        }
        
        Arrays.sort(arrival);
        int ans = 0;
        
        for (int i = 0; i < arrival.length; i++) {
            if (arrival[i] <= i) {
                break;
            }
            
            ans++;
        }
        
        return ans;
    }
}