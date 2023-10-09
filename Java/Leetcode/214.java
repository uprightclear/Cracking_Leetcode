class Solution {
    public String shortestPalindrome(String s) {
        int j = 0;
        for(int i = s.length() - 1; i >= 0; i--) {
            if(s.charAt(i) == s.charAt(j)) j++;
        }
        //It's a palindrome itself
        if(j == s.length()) return s;
        String remain = s.substring(j);
        String heading  = new StringBuffer(remain).reverse().toString();
        return heading + shortestPalindrome(s.substring(0, j)) + remain;
    }
}