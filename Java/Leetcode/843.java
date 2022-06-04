/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     public int guess(String word) {}
 * }
 */
class Solution {
    int N = 6;
    
    public void findSecretWord(String[] words, Master master) {
        Set<Integer> options = new HashSet<>();
        for (int i = 0; i < words.length; i++) options.add(i);
        while (options.size() > 0) {
            int min = Integer.MAX_VALUE;
            int minIdx = -1;
            for (int i : options) {
                int max = maxLoss(i, words, options);
                if (max < min) {
                    min = max;
                    minIdx = i;
                }
            }
            int match = master.guess(words[minIdx]);
            //made the correct guess, return
            if (match == N) return;
            Set<Integer> next = new HashSet<>();
            for (int i : options) {
                if (similarity(words[minIdx], words[i]) == match) {
                    next.add(i);
                }
            }
            options = next;
        }
    }
    
    private int maxLoss(int wordIdx, String[] words, Set<Integer> options) {
        int[] bucket = new int[N];
        int maxLoss = 0;
        for (int i : options) {
            if (!words[wordIdx].equals(words[i])) {
                int sim = similarity(words[wordIdx], words[i]);
                bucket[sim]++;
                maxLoss = Math.max(maxLoss, bucket[sim]);
            }
        }
        return maxLoss;
    }
    
    private int similarity(String s1, String s2) {
        int match = 0;
        for (int i = 0; i < N; i++) {
            match += s1.charAt(i) == s2.charAt(i) ? 1 : 0;
        }
        return match;
    }
}