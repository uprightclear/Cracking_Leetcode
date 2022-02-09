class Solution {
    public List<String> simplifiedFractions(int n) {
        List<String> ans = new ArrayList<>();
        for(int y = n; y > 1; y--) {
            for(int x = y - 1; x > 0; x--) {
                if(isValid(x, y)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(x).append('/').append(y);
                    ans.add(sb.toString());
                }
            }
        }
        return ans;
    }

    public boolean isValid(int x, int y) {
        for(int i = 2; i <= x; i++) {
            if(x % i == 0 && y % i == 0) return false;
        }
        return true;
    }
}