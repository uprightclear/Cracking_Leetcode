class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int maxf = 0, i = 0, n = answerKey.length(), count[] = new int[26];
        for (int j = 0; j < n; ++j) {
            maxf = Math.max(maxf, ++count[answerKey.charAt(j) - 'A']);
            if (j - i + 1 > maxf + k)
                --count[answerKey.charAt(i++) - 'A'];
        }
        return n - i;
    }
}


class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int res = 0, maxf = 0, count[] = new int[26];
        for(int i = 0; i < answerKey.length(); i++) {
            maxf = Math.max(maxf, ++count[answerKey.charAt(i) - 'A']);
            if(maxf + k > res) res++;
            else --count[answerKey.charAt(i - res) - 'A'];
        }
        return res;
    }
}