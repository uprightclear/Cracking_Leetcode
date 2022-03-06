class Solution {
    public List<String> cellsInRange(String s) {
        int startX = s.charAt(1) - '1';
        int startY = s.charAt(0) - 'A';
        int endX = s.charAt(4) - '1';
        int endY = s.charAt(3) - 'A';
        List<String> ans = new ArrayList<>();
        for(int y = startY; y <= endY; y++) {
            for(int x = startX; x <= endX; x++) {
                StringBuilder sb = new StringBuilder();
                sb.append((char)(y + 'A'));
                sb.append((char)(x + '1'));
                ans.add(sb.toString());
            }
        }
        return ans;
    }
}