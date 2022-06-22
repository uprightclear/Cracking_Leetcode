class Solution {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        Arrays.sort(slots1, (a, b) -> a[0] - b[0]); // sort increasing by start time
        Arrays.sort(slots2, (a, b) -> a[0] - b[0]); // sort increasing by start time
        int i = 0, j = 0;
        int m = slots1.length, n = slots2.length;
        while(i < m && j < n) {
            // Find intersect between slots1[i] and slots2[j]
            int intersectStart = Math.max(slots1[i][0], slots2[j][0]);
            int intersectEnd = Math.min(slots1[i][1], slots2[j][1]);
            if (intersectEnd - intersectStart >= duration) // Found the result
                return Arrays.asList(intersectStart, intersectStart + duration);

            if(slots1[i][1] < slots2[j][1]) i++;
            else j++;
        }
        return new ArrayList<>();
    }
}