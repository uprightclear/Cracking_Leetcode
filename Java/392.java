class Solution {
    public boolean isSubsequence(String s, String t) {
        int lens = s.length();
        int lent = t.length();
        if(lens > lent) return false;
        int pre = 0;
        int ans = 0;
        for(int i = 0; i < lens; i++) {
            char cur = s.charAt(i);
            for(int j = pre; j < lent; j++) {
                if(t.charAt(j) == cur) {
                    ans++;
                    pre = j + 1;
                    break;
                }
                if(j == lent - 1) return false;
            }
        }
        return ans == lens;
    }
}


class Solution {
    public boolean isSubsequence(String s, String t) {
        Integer leftBound = s.length(), rightBound = t.length();
        Integer pLeft = 0, pRight = 0;

        while (pLeft < leftBound && pRight < rightBound) {
            // move both pointers or just the right pointer
            if (s.charAt(pLeft) == t.charAt(pRight)) {
                pLeft += 1;
            }
            pRight += 1;
        }
        return pLeft == leftBound;
    }
}