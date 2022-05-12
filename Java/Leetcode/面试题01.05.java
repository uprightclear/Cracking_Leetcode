class Solution {
    public boolean oneEditAway(String first, String second) {
        int m = first.length();
        int n = second.length();
        //保证第一个字符串的长度大于等于第二个字符串
        if (m < n) {
            return oneEditAway(second, first);
        }
        if (m - n > 1) {
            return false;
        }

        int i = 0;
        int j = 0;
        int cnt = 0;
        while (i < m && j < n) {
            if (first.charAt(i) == second.charAt(j)) {
                i++;
                j++;
            } else {
                if (m == n) {  //长度相等情况下相当于一次替换
                    j++;
                }
                //如果不走上面if，即长度不等情况，相当于一次插入或者删除
                i++;
                cnt++;
                if (cnt > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}