class Solution {
    public int oddEvenJumps(int[] arr) {
        int n  = arr.length, res = 1;
        boolean[] higher = new boolean[n], lower = new boolean[n];
        //higher[i]: whether can index i jump higher
        //lower[i]: whether can index i jump lower
        higher[n - 1] = lower[n - 1] = true;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(arr[n - 1], n - 1);
        for (int i = n - 2; i >= 0; --i) {
            Map.Entry<Integer, Integer> hi = map.ceilingEntry(arr[i]), lo = map.floorEntry(arr[i]);
            if (hi != null) higher[i] = lower[(int)hi.getValue()];
            if (lo != null) lower[i] = higher[(int)lo.getValue()];
            if (higher[i]) res++;
            map.put(arr[i], i);
        }
        return res;
    }
}