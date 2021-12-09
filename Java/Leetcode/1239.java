class Solution {
    public int maxLength(List<String> arr) {
        // Use depth first search recursion through arr
        // building from an initial empty string
        return dfs(arr, 0, "");
    }

    private int dfs(List<String> arr, int pos, String res) {    
        // Use a set to check res for duplicate characters
        Set<Character> resSet = new HashSet<>();
        for (char c : res.toCharArray())
            resSet.add(c);
        if (res.length() != resSet.size())
            return 0;

        // Recurse through each possible next option
        // and find the best answer
        int best = res.length();
        for (int i = pos; i < arr.size(); i++)
            best = Math.max(best, dfs(arr, i + 1, res + arr.get(i)));
        return best;
    }
}