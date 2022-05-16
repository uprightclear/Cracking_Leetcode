class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] orderMap = new int[26];
        for (int i = 0; i < order.length(); i++){
            orderMap[order.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < words.length - 1; i++) {

            for (int j = 0; j < words[i].length(); j++) {
                // If we do not find a mismatch letter between words[i] and words[i + 1],
                // we need to examine the case when words are like ("apple", "app").
                if (j >= words[i + 1].length()) return false;

                if (words[i].charAt(j) != words[i + 1].charAt(j)) {
                    int currentWordChar = words[i].charAt(j) - 'a';
                    int nextWordChar = words[i + 1].charAt(j) - 'a';
                    if (orderMap[currentWordChar] > orderMap[nextWordChar]) return false;
                    // if we find the first different letter and they are sorted,
                    // then there's no need to check remaining letters
                    else break;
                }
            }
        }

        return true;
    }
}

class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        for(int i = 1; i < words.length; i++) {
            String first = words[i - 1];
            String second = words[i];
            if(first.startsWith(second) && first.length() > second.length()) return false;
            for(int j = 0; j < Math.min(first.length(), second.length()); j++) {
                if(first.charAt(j) != second.charAt(j)) {
                    if(order.indexOf(first.charAt(j)) > order.indexOf(second.charAt(j))) return false;
                    else break;
                }
            }
        }
        return true;
    }
}