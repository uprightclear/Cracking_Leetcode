class Solution {
    int[] dx, dy;

    public int[] executeInstructions(int n, int[] startPos, String s) {
        dx = new int[256];
        dy = new int[256];
        dy['L'] = -1;
        dy['R'] = 1;
        dx['U'] = -1;
        dx['D'] = 1;
        int[] result = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            result[i] = execute(n, startPos, s.substring(i));
        }
        return result;
    }

    int execute(int n, int[] startPos, String s) {
        int x = startPos[0], y = startPos[1];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            x += dx[c];
            y += dy[c];
            if (x < 0 || x >= n || y < 0 || y >= n) {
                return i;
            }
        }
        return s.length();
    }
}