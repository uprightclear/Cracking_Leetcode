//TLE
class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int len = quality.length;
        double ans = Double.MAX_VALUE;
        
        for(int i = 0; i < len; i++) {
            double factor = (double) wage[i] / quality[i];
            double[] pay = new double[len];
            int t = 0;
            for(int worker = 0; worker < len; worker++) {
                double payeach = factor * quality[worker];
                if(payeach < wage[worker]) continue;
                pay[t++] = payeach;
            }
            
            if(t < k) continue;
            Arrays.sort(pay, 0, t);
            
            double tmp = 0;
            for(int j = 0; j < k; j++) {
                tmp += pay[j];
            }
            
            ans = Math.min(ans, tmp);
        }
        
        return ans;
    }
}

class Solution {
    public double mincostToHireWorkers(int[] q, int[] w, int K) {
        double[][] workers = new double[q.length][2];
        for (int i = 0; i < q.length; ++i)
            workers[i] = new double[]{(double)(w[i]) / q[i], (double)q[i]};
        Arrays.sort(workers, (a, b) -> Double.compare(a[0], b[0]));
        double res = Double.MAX_VALUE, qsum = 0;
        PriorityQueue<Double> pq = new PriorityQueue<>();
        for (double[] worker: workers) {
            qsum += worker[1];
            pq.add(-worker[1]);
            if (pq.size() > K) qsum += pq.poll();
            if (pq.size() == K) res = Math.min(res, qsum * worker[0]);
        }
        return res;
    }
}