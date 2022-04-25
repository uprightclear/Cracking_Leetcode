class Solution {
    public int[] countRectangles(int[][] rectangles, int[][] points) {
        Map<Integer, ArrayList<Integer>> htl = new HashMap<>();
        for(int i = 0; i < rectangles.length; i++) {
            if(htl.containsKey(rectangles[i][1])) htl.get(rectangles[i][1]).add(rectangles[i][0]);
            else {
                htl.put(rectangles[i][1], new ArrayList<>());
                htl.get(rectangles[i][1]).add(rectangles[i][0]);
            }
        }
        
        for(int k : htl.keySet()) Collections.sort(htl.get(k));
        int[] ans = new int[points.length];
        for(int i = 0; i < points.length; i++) {
            int x = points[i][0], y = points[i][1], cnt = 0;
            for(int j = y; j <= 100; j++) {
                if(htl.containsKey(j)) {
                    cnt += htl.get(j).size() - bs(htl.get(j), x);
                }
            }
            ans[i] = cnt;
        }
        return ans;
    }
    
    public int bs(List<Integer> arr, int x) {
        int l = 0, r = arr.size();
        //int ans = arr.size();
        while(l < r) {
            int m = l + (r - l) / 2;
            if(arr.get(m) >= x) {
                r = m;
            } else l = m + 1;
        }
        return l;
    }
}