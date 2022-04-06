class Solution {
    public boolean rotateString(String s, String goal) {
        int n = s.length();
        for(int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            if(sb.append(s.substring(i)).append(s.substring(0, i)).toString().equals(goal)) return true;
        }
        return false;
    }
}


class Solution {
    public boolean rotateString(String s, String goal) {
        return s.length() == goal.length() && (s + s).contains(goal);
    }
}