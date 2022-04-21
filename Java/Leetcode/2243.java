class Solution {
    public String digitSum(String s, int k) {
        if(s.length() <= k) return s;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i += k) {
            int cur = 0;
            for(int j = i; j < Math.min(i + k, s.length()); j++) cur += s.charAt(j) - '0';
            sb.append(String.valueOf(cur));
        }
        return digitSum(sb.toString(), k);
    }
}