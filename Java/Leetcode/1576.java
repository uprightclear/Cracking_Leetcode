class Solution {
    public String modifyString(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        for(int i = 0; i < n; i++) {
            if(arr[i] == '?') {
                for(char ch = 'a'; ch <= 'z'; ch++) {
                    if((i > 0 && arr[i - 1] == ch) || (i < n - 1 && arr[i + 1] == ch)) continue;
                    arr[i] = ch;
                    break;
                }
            }
        }
        return new String(arr);
    }
}