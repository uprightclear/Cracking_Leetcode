//key point: if we meet the ] needing to be swaped, 
//we should always swap it and the last [ to make sure the swaped ] won't be swaped any more
class Solution {
    public int minSwaps(String s) {
        int cnt = 0, ans = 0;
        for(char c : s.toCharArray()) {
            if(c == '[') cnt += 1;
            else if (cnt > 0) cnt--;
            else {
                cnt++;
                ans++;
            }
        }
        return ans;
    }
}