class Solution {
    public int countPoints(String rings) {
        boolean[][] color = new boolean[10][26];
        for(int i = 0; i < rings.length(); i += 2) {
            color[rings.charAt(i + 1) - '0'][rings.charAt(i) - 'A'] = true;
        }
        
        int ans = 0;
        for(int i = 0; i < 10; i++) {
            if(color[i]['R' - 'A'] && color[i]['G' - 'A'] && color[i]['B' - 'A']) ans++;
        }
        return ans;
    }
}