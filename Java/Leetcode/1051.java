class Solution {
    public int heightChecker(int[] heights) {
        int len = heights.length;
        int[] ori = new int[len];
        System.arraycopy(heights, 0, ori, 0, len);
        Arrays.sort(heights);
        int ans = 0;
        for(int i = 0; i < len; i++) {
            if(ori[i] != heights[i]) ans++;
        }
        return ans;
    }
}