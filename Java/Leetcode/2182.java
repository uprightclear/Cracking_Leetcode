class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] freq = new int[26];
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()) freq[c - 'a']++;
        for(int i = 25; i >= 0; i--) {
            if(freq[i] == 0) continue;
            int j = Math.min(freq[i], repeatLimit);
            while(j-- > 0) {
                sb.append((char)('a' + i));
                freq[i]--;
            }
            if(freq[i] == 0) continue;
            for(j = i - 1; j >= 0 && freq[j] == 0; j--);
            if(j == -1) return sb.toString();
            sb.append((char)('a' + j));
            freq[j]--;
            i++;//keep i
        }
        return sb.toString();
    }
}