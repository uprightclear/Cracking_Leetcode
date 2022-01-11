class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int len = arr.length;
        if(len == 0) return new int[0];
        int[] sorted = Arrays.copyOf(arr, len);
        Arrays.sort(sorted);
        Map<Integer, Integer> index = new HashMap<>();
        index.put(sorted[0], 1);
        int rank = 1;
        for(int i = 1; i < len; i++) {
            if(sorted[i] == sorted[i - 1]) continue;
            rank++;
            index.put(sorted[i], rank);
        }
        int[] ans = new int[len];
        for(int i = 0; i < len; i++) {
            ans[i] = index.get(arr[i]);
        }
        return ans;
    }
}