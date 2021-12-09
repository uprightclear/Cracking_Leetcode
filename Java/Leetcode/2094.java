class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int len = digits.length;
        Set<Integer> ans = new HashSet<>();
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                for(int k = 0; k < len; k++) {
                    if(i == j || j == k || i == k) continue;
                    if(digits[i] != 0 && digits[k] % 2 == 0) 
                        ans.add(digits[i] * 100 + digits[j] * 10 + digits[k]);
                }
            }
        }
        List<Integer> list = new ArrayList<>(ans);
        Collections.sort(list);
        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++) res[i] = list.get(i);
        return res;
    }
}