class Solution {
    public String longestWord(String[] words) {
        Arrays.sort(words, (a, b) -> {
            return a.length() == b.length() ? b.compareTo(a) : a.length() - b.length();
        });

        String longest = "";
        Set<String> set = new HashSet<>();
        set.add("");
        for(String word : words) {
            if(set.contains(word.substring(0, word.length() - 1))) {
                set.add(word);
                longest = word;
            }
        }
        return longest;
    }
}