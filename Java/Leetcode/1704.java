class Solution {
    public boolean halvesAreAlike(String s) {
        int n = s.length();
        return countVowel(0, n / 2, s) == countVowel(n / 2, n, s);
    }

    private int countVowel(int start, int end, String s) {
        String vowels = "aeiouAEIOU";
        int answer = 0;
        for (int i = start; i < end; i++) {
            if (vowels.indexOf(s.charAt(i)) != -1) {
                answer++;
            }
        }
        return answer;
    }
}