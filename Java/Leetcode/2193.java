class Solution {
    public int minMovesToMakePalindrome(String s) {
        int res = 0;
        while (s.length() > 0) {
            int i = s.indexOf(s.charAt(s.length() - 1));
            //only 1 charcter in this String so we should put this char in the middle
            if (i == s.length() - 1) res += i / 2;
            else {
                res += i;
                s = s.substring(0, i) + s.substring(i + 1);
            }
            s = s.substring(0, s.length() - 1);
        }
        return res;
    }
}