class Solution {
    public List<List<Integer>> findRLEArray(int[][] encoded1, int[][] encoded2) {
        List<List<Integer>> ans = new ArrayList<>();
        int p1 = 0, p2 = 0;
        while(p1 < encoded1.length) {
            int len = Math.min(encoded1[p1][1], encoded2[p2][1]);
            int mult = encoded1[p1][0] * encoded2[p2][0];
            
            if(ans.size() > 0 && ans.get(ans.size() - 1).get(0) == mult) { //to handle cases like [[1,3],[2,3]] * [[6,3],[3,3]] --> [[6,6]]
                ans.get(ans.size() - 1).set(1, ans.get(ans.size() - 1).get(1) + len);
            } else {
                ans.add(Arrays.asList(mult, len));
            }
            
            encoded1[p1][1] -= len;
            encoded2[p2][1] -= len;
            if(encoded1[p1][1] == 0) p1++;
            if(encoded2[p2][1] == 0) p2++;
        }
        return ans;
    }
}