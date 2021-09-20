class Solution {
    public int lengthOfLastWord(String s) {
        char[] array = s.toCharArray();
        int ans = 0;
        for(int i = array.length - 1; i >= 0; i--){
            if(array[i] != ' '){
                ans++;
            }else if(array[i] == ' ' && ans != 0){
                return ans;
            }
        }
        return ans;
    }
}