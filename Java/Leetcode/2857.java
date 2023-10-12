class Solution {
    public int countPairs(List<List<Integer>> coordinates, int k) {
        Map<Integer, Map<Integer, Integer>> count = new HashMap<>();
        int res = 0;
        for (List<Integer> c : coordinates) {
            int x1 = c.get(0), y1 = c.get(1);
            for (int x = 0; x <= k; x++) {
                int x2 = x1 ^ x, y2 = y1 ^ (k - x);
                if (count.containsKey(x2) && count.get(x2).containsKey(y2))
                    res += count.get(x2).get(y2);
            }
            count.computeIfAbsent(x1, x -> new HashMap<>()).put(y1, count.get(x1).getOrDefault(y1, 0) + 1);
        }
        return res;
    }
}