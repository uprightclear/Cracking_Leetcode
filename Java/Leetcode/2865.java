class Solution {
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        int pickEl = 0, pickId = 0;
        long max = 0;
        for(int i = 0; i < maxHeights.size(); i++){
            pickEl = maxHeights.get(i);
            pickId = i;
            max = Math.max(max, fun(maxHeights, pickEl, pickId));
        }
        return max;
    }
    long fun(List<Integer> maxHeights, int pickEl, int pickId){
        long ans = maxHeights.get(pickId), min = maxHeights.get(pickId);
        for(int i = pickId - 1; i >= 0; i--){
            min = Math.min(min, maxHeights.get(i));
            ans += min;
        }
        min = maxHeights.get(pickId);
        for(int i = pickId+1; i < maxHeights.size(); i++){
            min = Math.min(min, maxHeights.get(i));
            ans += min;
        }
        return ans;
    }
}