class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        int a = 0, b = 0, ax = 0, bx = 0;
        for (int i = 0; i < n / 2; ++i)
            if (num.charAt(i) == '?') ++ax;
            else a += num.charAt(i) - '0';
        for (int i = n / 2; i < n; ++i)
            if (num.charAt(i) == '?') ++bx;
            else b += num.charAt(i) - '0';
        int x = ax + bx;
        if ((x & 1) != 0) return true;
        int xa = (ax + 1) / 2, // how many numbers that Alice would fill into `a`.
			xb = x / 2 - xa, // how many numbers that Alice would fill into `b`.
			ya = ax - xa, // how many numbers that Bob would fill into `a`.
			yb = bx - xb; // how many numbers that Bob would fill into `b`.
        // [a, ya * 9 + a], [xb * 9 + b, xb * 9 + b + yb * 9]  // Alice focus on minimizing a.
        if (ya * 9 + a < xb * 9 + b) return true;
        // [xa * 9 + a, xa * 9 + a + xb * 9], [b, yb * 9 + b] // Alice focus on maxmizing a.
        if (xa * 9 + a > yb * 9 + b) return true;
        return false;
    }
}