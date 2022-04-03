class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        ans.add(new ArrayList<>());
        Map<Integer, Integer> cnt = new TreeMap<>();
        for(int[] match : matches) {
            cnt.put(match[0], cnt.getOrDefault(match[0], 0));
            cnt.put(match[1], cnt.getOrDefault(match[1], 0) + 1);
        }
        for(int m : cnt.keySet()) {
            if(cnt.get(m) == 0) ans.get(0).add(m);
            else if(cnt.get(m) == 1) ans.get(1).add(m);
        }
        return ans;
    }
}