class Solution {
    private int len;
    private List<String> res = new ArrayList<>();
    private Deque<String> path = new ArrayDeque<>(4);

    public List<String> restoreIpAddresses(String s) {
        this.len = s.length();
        if (len > 12 || len < 4) {
            return res;
        }

        dfs(s, 0, 4);
        return res;
    }

    // 需要一个变量记录剩余多少段还没被分割
    private void dfs(String s, int begin, int residue) {
        if (begin == len) {
            if (residue == 0) {
                res.add(String.join(".", path));
            }
            return;
        }

        for (int i = begin; i < begin + 3; i++) {
            if (i >= len) {
                break;
            }
            //current residue is not long enough
            if ((residue - 1) * 3 < len - 1 - i) {
                continue;
            }
            //current residue is too long
            if(residue - 1 > len - 1 - i){
                break;
            }

            if (judgeIpSegment(s, begin, i)) {
                String currentIpSegment = s.substring(begin, i + 1);
                path.addLast(currentIpSegment);

                dfs(s, i + 1, residue - 1);
                path.removeLast();
            }
        }
    }

    private boolean judgeIpSegment(String s, int left, int right) {
        int len = right - left + 1;
        if (len > 1 && s.charAt(left) == '0') {
            return false;
        }

        int res = 0;
        while (left <= right) {
            res = res * 10 + s.charAt(left) - '0';
            left++;
        }

        return res >= 0 && res <= 255;
    }
}

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        dfs(ans, s, 0, 4);
        return ans;
        
    }
    public void dfs(List<String> ans, String s, int start, int dot){
        if(dot == 0){
            if(start == s.length()){
                ans.add(s.substring(0, s.length() - 1));
            }
            return;
        }
        if(dot < 0 || start >= s.length()) return;
        for(int i = start; i < Math.min(start + 3, s.length()); i++){
            int val = Integer.valueOf(s.substring(start, i + 1));
            if(val >= 0 && val <= 255){
                if((val == 0 && i != start) || val > 0 && s.charAt(start)=='0') continue;
                dfs(ans, s.substring(0, i + 1) + "." + s.substring(i + 1), i + 2, dot - 1);
            }
        }
    }
}