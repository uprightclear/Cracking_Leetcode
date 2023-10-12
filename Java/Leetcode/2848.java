class Solution {
    public int numberOfPoints(List<List<Integer>> nums) {
        Set<Integer> set = new HashSet();
        for(List<Integer> al : nums) {
            for(int i = al.get(0); i <= al.get(1); i++) {
                set.add(i);
            }
        }
        return set.size();
    }
}