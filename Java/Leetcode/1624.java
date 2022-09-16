class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int[] firstIndex = new int[26];
        Arrays.fill(firstIndex, -1);
        int maxLength = -1;
        for (int i = 0; i < s.length(); i++) {
            if (firstIndex[s.charAt(i) - 'a'] < 0) {
                firstIndex[s.charAt(i) - 'a'] = i;
            } else {
                maxLength = Math.max(maxLength, i - firstIndex[s.charAt(i) - 'a'] - 1);
            }
        }
        return maxLength;
    }
}