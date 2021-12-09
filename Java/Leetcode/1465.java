class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        long hmax = horizontalCuts[0];
        long vmax = verticalCuts[0];
        for(int i = 1; i <= horizontalCuts.length; i++) {
            if(i < horizontalCuts.length) {
                hmax = Math.max(hmax, horizontalCuts[i] - horizontalCuts[i - 1]);
            }else {
                hmax = Math.max(hmax, h - horizontalCuts[i - 1]);
            }
        }
        
        for(int i = 1; i <= verticalCuts.length; i++) {
            if(i < verticalCuts.length) {
                vmax = Math.max(vmax, verticalCuts[i] - verticalCuts[i - 1]);
            }else {
                vmax = Math.max(vmax, w - verticalCuts[i - 1]);
            }
        }
        
        return (int)((hmax * vmax) % (1000000007));
    }
}