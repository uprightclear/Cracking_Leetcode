class Solution {
    public String maximumOddBinaryNumber(String s) {
        int len = s.length();
        int cnt = 0;
        for(char c : s.toCharArray()) {
            if(c == '1') cnt++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < len - 1; i++) {
            if(cnt-- > 1) sb.append('1');
            else sb.append('0');
        }
        sb.append('1');
        return sb.toString();
    }
}