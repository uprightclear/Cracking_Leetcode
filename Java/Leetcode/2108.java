class Solution {
    public String firstPalindrome(String[] words) {
        for(String w : words) {
            boolean found = true;
            for(int i = 0, j = w.length() - 1; i < j; i++, j--) {
                if(w.charAt(i) != w.charAt(j)) {
                    found = false;
                    break;
                }
            }
            if(found) return w;
        }
        return "";
    }
}