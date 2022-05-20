class Solution {
    public long numberOfWays(String s) {
        int len = s.length();
        long totalZeroes = 0;
        for(char c : s.toCharArray()) {
            if(c == '0') totalZeroes++;
        }
        long totalOnes = len - totalZeroes;
        
        long cur1 = s.charAt(0) == '1' ? 1 : 0;
        long cur0 = s.charAt(0) == '0' ? 1 : 0;
        long ans = 0;
        //排列组合，分别找左右两边的 0/1 的个数
        for(int i = 1; i < len; i++) {
            if(s.charAt(i) == '0') {//we need to find 1 in the left and in the right
                ans += cur1 * (totalOnes - cur1);
                cur0++;
            } else {//we need to find 0 in the left and in the right
                ans += cur0 * (totalZeroes - cur0);
                cur1++;
            }
        }
        return ans;
    }
}