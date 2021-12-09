class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int ans = 0;
        int i = 0;
        while(i < s.length()) {
            int currentValue = map.get(s.charAt(i));
            int nextValue = 0;
            if(i + 1 < s.length()) {
                nextValue = map.get(s.charAt(i + 1));
            }
            
            if(currentValue < nextValue) {
                ans += nextValue - currentValue;
                i += 2;
            } else {
                ans += currentValue;
                i++;
            }
        }
        return ans;
    }
}