class Solution {
    public int countCollisions(String directions) {
        int ans = 0;
        int S = 0, R = 0;
        for(char c : directions.toCharArray()) {
            if(c == 'L') {
                if(S + R == 0) continue;
                if(R > 0) ans += R + 1;
                else ans += S;
                S = 1;
                R = 0;
            }
            if(c == 'R') {
                S = 0;
                R++;
            }
            if(c == 'S') {
                ans += R;
                S = 1;
                R = 0;
            }
        }
        return ans;
    }
}