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