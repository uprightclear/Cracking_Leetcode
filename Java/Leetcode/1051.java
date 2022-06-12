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



class Solution {
    public int heightChecker(int[] heights) {
        int m = Arrays.stream(heights).max().getAsInt();
        int[] cnt = new int[m + 1];
        for (int h : heights) {
            ++cnt[h];
        }

        int idx = 0, ans = 0;
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= cnt[i]; ++j) {
                if (heights[idx] != i) {
                    ++ans;
                }
                ++idx;
            }
        }
        return ans;
    }
}