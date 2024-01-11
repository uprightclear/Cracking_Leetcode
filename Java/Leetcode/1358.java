class Solution {
    public int numberOfSubstrings(String s) {
        if(s.length() <= 3){
            if(s.length() == 3 && s.contains("a") && s.contains("b") && s.contains("c")){
                return 1;
            }
            return 0;
        }
        int start = 0; 
        int end = 2;
        int count = 0;
        while(end < s.length()){
            String temp = s.substring(start, end + 1);
            while(start <= end && end - start >= 2 && temp.contains("a") && temp.contains("b") && temp.contains("c")){
                count += s.length() - end;
                start++;
                temp = s.substring(start, end + 1);
            }
            end++;
        }
        return count;
    }
}