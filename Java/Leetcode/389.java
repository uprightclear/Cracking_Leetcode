class Solution {
    public char findTheDifference(String s, String t) {

        char extraChar = ' ';

        // Prepare a counter for string s.
        // This hash map holds the characters as keys and respective frequency as value.
        HashMap <Character,Integer> counterS = new HashMap <>();
        for (char c : s.toCharArray()) {
            counterS.put(c, counterS.getOrDefault(c, 0) + 1);
        }

        // Iterate through string t and find the character which is not in s.
        for (char c : t.toCharArray()) {
            int countOfChar = counterS.getOrDefault(c, 0);
            if (countOfChar == 0) {
                extraChar = c;
                break;
            } else {

                // Once a match is found we reduce frequency left.
                // This eliminates the possibility of a false match later.
                counterS.put(c, countOfChar - 1);
            }
        }
        return extraChar;
    }
}

class Solution {
    public char findTheDifference(String s, String t) {

        // Initialize ch with 0, because 0 ^ X = X
        // 0 when XORed with any bit would not change the bits value.
        char ch = 0;

        // XOR all the characters of both s and t.
        for (int i = 0; i < s.length(); i += 1) {
            ch ^= s.charAt(i);
        }
        for (int i = 0; i < t.length(); i += 1) {
            ch ^= t.charAt(i);
        }

        // What is left after XORing everything is the difference.
        return ch;
    }
}