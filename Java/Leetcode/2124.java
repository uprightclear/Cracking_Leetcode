class Solution {
    public boolean checkString(String s) {
        return !s.contains("a") || !s.contains("b") || s.lastIndexOf('a') < s.indexOf('b');
    }
}