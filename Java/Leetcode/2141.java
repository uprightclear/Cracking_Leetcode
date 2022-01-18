class Solution {
    public long maxRunTime(int n, int[] A) {
        Arrays.sort(A);
        long sum = 0;
        for (int a: A)
            sum += a;
        int k = 0, na = A.length;
        while (A[na - 1 - k] > sum / (n - k))
            sum -= A[na - 1 - k++];
        return sum / (n - k);
    }
}


class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long l = 1, r = Arrays.stream(batteries).mapToLong(i -> i).sum() / n;
        while (l + 1 < r) {
            long mid = (l + r) / 2;
            if (check(n, batteries, mid)) {
                l = mid;
           } else {
                r = mid;
           }
       }
        return check(n, batteries, r) ? r : l;
   }
 
    // 判断电池能否供给 n 台电脑使用 time 分钟
    // 相当于每块电池最多使用 time 分钟
    // 如果一块电池容量小于 time 分钟，那么它需要和其他电池拼一起才能组成 time 分钟
    // 如果一块电池容量多于 time 分钟，那么可以认为它将被浪费，可以认为这个电池容量只有 time 分钟
    // 因为换电池是不消耗时间的，所以只需检查电池容量之和是否达到了 time * n 即可
    private boolean check(int n, int[] batteries, long time) {
        return Arrays.stream(batteries).mapToLong(i -> Math.min((long) i, time)).sum() >= n * time;
   }
 }