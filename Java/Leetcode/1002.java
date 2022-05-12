class Solution {
    public List<String> commonChars(String[] words) {
        int[] count = new int[26];
        Arrays.fill(count, Integer.MAX_VALUE);
        for(String word : words) {
            int[] cnt = new int[26];
            for(char c : word.toCharArray()) {
                cnt[c - 'a']++;
            }
            for(int i = 0; i < 26; i++) {
                count[i] = Math.min(count[i], cnt[i]);
            }
        }
        List<String> ans = new ArrayList<>();
        for(char i = 'a'; i <= 'z'; i++) {
            while(count[i - 'a']-- > 0) ans.add("" + i);
        }
        return ans;
    }
}