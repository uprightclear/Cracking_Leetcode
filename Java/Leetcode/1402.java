class Solution {
    public int maxSatisfaction(int[] s) {
        Arrays.sort(s);
        int max = 0, sum = 0, count = 1;
        for (int i = 0; i < s.length; i++) {
            for (int j = i; j < s.length; j++) {
                sum += s[j] * count++;
            }
            max = Math.max(max, sum);
            sum = 0;
            count = 1;
        }
        return max;
    }
}