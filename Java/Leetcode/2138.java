class Solution {
    public String[] divideString(String s, int k, char fill) {
        List<String> ans = new ArrayList<>();
        int len = s.length();
        int m = len / k;
        int n = len % k;
        int start = 0;
        while(m-- > 0) {
            ans.add(s.substring(start, start + k));
            start += k;
        }
        if(n != 0) {
            StringBuilder sb = new StringBuilder(s.substring(start));
            while(k - n > 0) {
                sb.append(fill);
                n++;
            }
            ans.add(sb.toString());
        }
        
        return ans.toArray(new String[ans.size()]);
    }
}