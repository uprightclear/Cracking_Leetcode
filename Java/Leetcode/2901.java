class Solution {
    public List<String> getWordsInLongestSubsequence(int n, String[] words, int[] groups) {
        List<Integer> dp = new ArrayList<>(groups.length);
        List<Integer> pv = new ArrayList<>(groups.length);

        for (int i = 0; i < groups.length; i++) {
            dp.add(1);
            pv.add(-1);
        }

        for (int i = 1; i < groups.length; i++) {
            for (int j = 0; j < i; j++) {
                if (groups[i] == groups[j]) continue;
                if (words[i].length() != words[j].length()) continue;

                int diff = 0;
                for (int k = 0; k < words[i].length(); k++) {
                    if (words[i].charAt(k) != words[j].charAt(k)) {
                        diff++;
                    }
                }

                if (diff != 1) continue;

                if (dp.get(j) + 1 > dp.get(i)) {
                    dp.set(i, dp.get(j) + 1);
                    pv.set(i, j);
                }
            }
        }

        int wi = dp.indexOf(Collections.max(dp));
        List<String> ans = new ArrayList<>();

        while (wi != -1) {
            ans.add(words[wi]);
            wi = pv.get(wi);
        }

        Collections.reverse(ans);
        return ans;
    }
}