class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<>();
        List<Integer> elements = new ArrayList<>();
        for(int num : nums) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
            elements.add(num);
        }
        
        Collections.sort(elements, new Comparator<Integer>(){
            public int compare(Integer a, Integer b) {
                return counts.get(a) == counts.get(b) ? b - a : counts.get(a) - counts.get(b); 
            }
        });
        
        int[] ans = new int[elements.size()];
        for(int i = 0; i < elements.size(); i++) {
            ans[i] = elements.get(i);
        }
        return ans;
    }
}