class Solution {
    public List<Integer> intersection(int[][] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        List<Integer> inEachArray = new ArrayList<>();
        for (int[] num : nums) {
            for (int x : num) {
                countMap.put(x, countMap.getOrDefault(x, 0) + 1);
                if (countMap.get(x) == nums.length) inEachArray.add(x);
            }
        }
        inEachArray.sort(Comparator.naturalOrder());
        return inEachArray;
    }
}