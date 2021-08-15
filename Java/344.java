class Solution {
    public void reverseString(char[] s) {
        int len = s.length;
        int l = 0, r = len - 1;
        while(l < r){
            char tmp = s[l];
            s[l] = s[r];
            s[r] = tmp;
            l++;
            r--;
        }
    }
}