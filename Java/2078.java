class Solution {
    public int maxDistance(int[] colors) {
        int ans = 0;
        for(int len = colors.length; len >= 1; len--) {
            for(int i = 0; i + len <= colors.length; i++) {
                if(colors[i] != colors[i + len - 1]) {
                    return len - 1;
                }
            }
        }
        return 0;
    }
}