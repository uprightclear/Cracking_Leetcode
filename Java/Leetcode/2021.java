class Solution {
    public int brightestPosition(int[][] lights) {
        TreeMap<Integer, Integer> line = new TreeMap<>();
        int bright = 0, max_bright = 0, res = 0;
        for (int[] l : lights) {
            line.put(l[0] - l[1], line.getOrDefault(l[0] - l[1], 0) + 1);
            line.put(l[0] + l[1] + 1, line.getOrDefault(l[0] + l[1] + 1, 0) - 1);
        }
        for (Integer light : line.keySet()) {
            bright += line.get(light);
            if (bright > max_bright) {
                max_bright = bright;
                res = light;
            }
        }
        return res;
    }
}