class Solution {
    public List<Integer> lastVisitedIntegers(List<String> words) {
        List<Integer> ans = new ArrayList<>();
        List<String> digits = new ArrayList<>();
        int k = 0;
        for (int i = 0; i < words.size(); i++) {
            String word = words.get(i);

            if (word.equals("prev")) {
                k++;
                ans.add((digits.size() - k < digits.size() && digits.size() - k >= 0) ? Integer.parseInt(digits.get(digits.size() - k)) : -1);
            }
            else {
                digits.add(word);
                k = 0;
            }
        }

        return ans;
    }
}