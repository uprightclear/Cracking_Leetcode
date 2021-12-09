class Solution {
    public int kthFactor(int n, int k) {
        for (int x = 1; x < n / 2 + 1; ++x) {
            if (n % x == 0) {
                --k;
                if (k == 0) {
                    return x;    
                }    
            }    
        }
        
        return k == 1 ? n : -1;
    }
}



//Better Solution
class Solution {
    public int kthFactor(int n, int k) {
        int count = 0, factor;
        for (factor = 1; factor * factor <= n; ++factor) {
            if (n % factor == 0) {
                ++count;
                if (count == k) {
                    return factor;
                }
            }
        }
        --factor;
        if (factor * factor == n) {
            --factor;
        }
        for (; factor > 0; --factor) {
            if (n % factor == 0) {
                ++count;
                if (count == k) {
                    return n / factor;
                }
            }
        }
        return -1;
    }
}