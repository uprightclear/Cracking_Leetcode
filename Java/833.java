class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        List<int[]> list  = new ArrayList<>();
        for(int i = 0; i < indices.length; i++) {
            list.add(new int[]{indices[i], i});
        }
        
        Collections.sort(list, (a, b) -> b[0] - a[0]);
        
        for(int[] sort : list) {
            int index = sort[0], place = sort[1];
            String source = sources[place], target = targets[place];
            if(s.substring(index, index + source.length()).equals(source)) {
                s = s.substring(0, index) + target + s.substring(index + source.length());
            }
        }
        return s;
    }
}