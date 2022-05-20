class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int a : arr) count.put(a, count.getOrDefault(a, 0) + 1);
        return count.size() == new HashSet<>(count.values()).size();
    }
}