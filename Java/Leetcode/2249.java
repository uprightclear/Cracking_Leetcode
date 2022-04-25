class Solution {
    public int countLatticePoints(int[][] circles) {
        Set<Long> points = new HashSet<>();
        for(int[] circle : circles) {
            int x = circle[0], y = circle[1], r = circle[2];
            for(int i = x - r; i <= x + r; i++) {
                for(int j = y - r; j <= y + r; j++) {
                    if(Math.abs(i - x) * Math.abs(i - x) + Math.abs(j - y) * Math.abs(j - y) <= r * r) 
                        points.add((long) i << 32 | j);
                }
            }
        }
        return points.size();
    }
}