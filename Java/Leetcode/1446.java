class Solution {
    public int maxPower(String s) {
        int ans = 1;
        int tmp = 1;
        char pre = s.charAt(0);
        for(int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == pre) {
                tmp++;
                ans = Math.max(ans, tmp);
            }else {
                pre = s.charAt(i);
                tmp = 1;
            }
        }
        return ans;
    }
}