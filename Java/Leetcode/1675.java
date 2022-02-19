public int minimumDeviation(int[] A) {
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
    int n = A.length, mi = Integer.MAX_VALUE, res = Integer.MAX_VALUE;
    for (int a : A) {
        if (a % 2 == 1) a *= 2;
        pq.add(-a);
        mi = Math.min(mi, a);
    }
    while (true) {
        int a = -pq.poll();
        res = Math.min(res, a - mi);
        if (a % 2 == 1) break;
        mi = Math.min(mi, a / 2);
        pq.add(-a / 2);
    }
    return res;
}