class Solution {
    public int wordCount(String[] startWords, String[] targetWords) {
        Set<Integer> startSet = new HashSet<>();
        for (var s : startWords) {
            startSet.add(toBinary(s));
       }
        int result = 0;
        for (var t : targetWords) {
            int target = toBinary(t);
            // 枚举追加的是哪个字母
            for (char c : t.toCharArray()) {
                if (startSet.contains(target - (1 << (c - 'a')))) {
                    result++;
                    break;
               }
           }
       }
        return result;
   }
 
    private int toBinary(String s) {
        int res = 0;
        for (char c : s.toCharArray()) {
            res += 1 << (c - 'a');
       }
        return res;
   }
 }