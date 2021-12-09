//bitmask
class CombinationIterator {
    public Deque < String > combinations = new ArrayDeque < String > ();

    public CombinationIterator(String characters, int combinationLength) {
        int n = characters.length();
        int k = combinationLength;

        // generate bitmasks from 0..00 to 1..11  
        for (int bitmask = 0; bitmask < 1 << n; bitmask++) {
            // use bitmasks with k 1-bits
            if (Integer.bitCount(bitmask) == k) {
                // convert bitmask into combination
                // 111 --> "abc", 000 --> ""
                // 110 --> "ab", 101 --> "ac", 011 --> "bc"
                StringBuilder curr = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if ((bitmask & (1 << n - j - 1)) != 0) {
                        curr.append(characters.charAt(j));
                    }
                }
                combinations.push(curr.toString());
            }
        }
    }

    public String next() {
        return combinations.pop();
    }

    public boolean hasNext() {
        return (!combinations.isEmpty());
    }
}

//backtrack
class CombinationIterator {
    public Deque < String > combinations = new ArrayDeque < String > ();
    String characters;
    int n, k;

    public void backtrack(int first, StringBuilder curr) {
        // if the combination is done
        if (curr.length() == k) {
            combinations.push(curr.toString());
            // speed up by non-constructing combinations 
            // with more than k elements  
            return;
        }

        for (int i = first; i < n; ++i) {
            // add i into the current combination
            curr.append(characters.charAt(i));
            // use next integers to complete the combination
            backtrack(i + 1, curr);
            // backtrack
            curr.deleteCharAt(curr.length() - 1);
        }
    }

    public CombinationIterator(String characters, int combinationLength) {
        this.n = characters.length();
        this.k = combinationLength;
        this.characters = characters;
        backtrack(0, new StringBuilder());
    }

    public String next() {
        return combinations.removeLast();
    }

    public boolean hasNext() {
        return (!combinations.isEmpty());
    }
}