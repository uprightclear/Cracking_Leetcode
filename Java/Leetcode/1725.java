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

class Solution {
    public int countGoodRectangles(int[][] rectangles) {
        int res = 0, maxLen = 0;
        for (int[] rectangle : rectangles) {
            int l = rectangle[0], w = rectangle[1];
            int k = Math.min(l, w);
            if (k == maxLen) {
                ++res;
            } else if (k > maxLen) {
                res = 1;
                maxLen = k;
            }
        }
        return res;
    }
}