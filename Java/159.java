class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int ans = 0;
        int start = 0, end = 1;
        int cnt = 1;
        int flag = -1;
        char mem = ' ';
        while(end < s.length()) {
            if(s.charAt(end) == s.charAt(start) || s.charAt(end) == mem) end++;
            else if(s.charAt(end) == s.charAt(end - 1)) end++;
            else if(s.charAt(end) != s.charAt(start) && cnt == 1) {
                mem = s.charAt(end);
                flag = end;
                cnt++;
                end++;
            } else {
                ans = Math.max(ans, end - start);
                mem = ' ';
                cnt = 1;
                start = flag;
                end = start + 1;
            }
        }
        ans = Math.max(ans, end - start);
        return ans;
    }
}


class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
      int n = s.length();
      if (n < 3) return n;
  
      // sliding window left and right pointers
      int left = 0;
      int right = 0;
      // hashmap character -> its rightmost position
      // in the sliding window
      HashMap<Character, Integer> hashmap = new HashMap<Character, Integer>();
  
      int max_len = 2;
  
      while (right < n) {
        // when the slidewindow contains less than 3 characters
        hashmap.put(s.charAt(right), right++);
  
        // slidewindow contains 3 characters
        if (hashmap.size() == 3) {
          // delete the leftmost character
          int del_idx = Collections.min(hashmap.values());
          hashmap.remove(s.charAt(del_idx));
          // move left pointer of the slidewindow
          left = del_idx + 1;
        }
  
        max_len = Math.max(max_len, right - left);
      }
      return max_len;
    }
  }