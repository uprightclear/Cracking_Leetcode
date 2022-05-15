class Solution {
    public int maxConsecutive(int bottom, int top, int[] special) {
        List<Integer> list = new ArrayList<>();
        for(int s : special) list.add(s);
        list.add(bottom - 1);
        list.add(top + 1);
        Collections.sort(list);
        int max = 0;
        for(int i = 1; i < list.size(); i++) {
            max = Math.max(max, list.get(i) - list.get(i - 1) - 1);
        }
        return max;
    }
}