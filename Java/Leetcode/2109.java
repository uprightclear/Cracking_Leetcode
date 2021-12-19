class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();
        int p = 0;
        for(int i = 0; i < s.length(); i++) {
            if(p < spaces.length && i == spaces[p]) {
                p++;
                sb.append(" ");
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}