class Solution {
    public int countGoodRectangles(int[][] rectangles) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for(int[] rectangle : rectangles) {
            int side = Math.min(rectangle[0], rectangle[1]);
            cnt.put(side, cnt.getOrDefault(side, 0) + 1);
        }
        int max = 0;
        int ans = 0;
        for(int k : cnt.keySet()) {
            if(k > max) {
                max = k;
                ans = cnt.get(k);
            }
        }
        return ans;
    }
}