class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        int[] result = new int[queries.length];
        Arrays.sort(items, (a, b) -> (a[0] - b[0]));
        
        for(int i = 1; i < items.length; ++i)
            items[i][1] = Math.max(items[i][1], items[i - 1][1]);

        for(int j = 0; j < queries.length; ++j)
            result[j] = binarySearch(items, queries[j]);
        
        return result;
    }
    
    private int binarySearch(int[][] items, int target) {
        int lo = 0, hi = items.length - 1;
        while(lo < hi) {
            int mid = (lo + hi + 1) >> 1;  //find rightmost item
            if(items[mid][0] > target)
                hi = mid - 1;
            else
                lo = mid;
        }
        return items[lo][0] <= target ? items[lo][1] : 0;
    }
}