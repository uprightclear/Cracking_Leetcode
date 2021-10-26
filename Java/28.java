//time limit exceeded
class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.isEmpty()) return 0;
        for(int i = 0; i <= haystack.length() - needle.length(); i++) {
            for(int j = 0; j < needle.length() && needle.charAt(j) == haystack.charAt(i + j); j++) {
                if(j == needle.length() - 1) return i;
            }
        }
        return -1;
    }
}


public class Solution {
    public int strStr(String haystack, String needle) {
        int l1 = haystack.length(), l2 = needle.length();
        if (l1 < l2) {
            return -1;
        } else if (l2 == 0) {
            return 0;
        }
        int threshold = l1 - l2;
        for (int i = 0; i <= threshold; ++i) {
            if (haystack.substring(i,i+l2).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}