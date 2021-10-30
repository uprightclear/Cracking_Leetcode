class Solution {
    /*
      Rabin-Karp with polynomial rolling hash.
      Search a substring of given length that occurs at least 2 times.
      Return start position if the substring exists and -1 otherwise.
    */
    String S;
    public int search(int L, int a, long modulus, int n, int[] nums) {
        // Compute the hash of string S[:L]
        long h = 0;
        for (int i = 0; i < L; ++i) {
            h = (h * a + nums[i]) % modulus;
        }
        
        // Store the already seen hash values for substrings of length L.
        HashMap<Long, List<Integer>> seen = new HashMap<Long, List<Integer>>();
        
        // Initialize the hashmap with the substring starting at index 0.
        seen.putIfAbsent(h, new ArrayList<Integer>());
        seen.get(h).add(0);
        
        // Const value to be used often : a**L % modulus
        long aL = 1;
        for (int i = 1; i <= L; ++i) {
            aL = (aL * a) % modulus;
        }
        
        for (int start = 1; start < n - L + 1; ++start) {
            // Compute rolling hash in O(1) time
            h = (h * a - nums[start - 1] * aL % modulus + modulus) % modulus;
            h = (h + nums[start + L - 1]) % modulus;
            List<Integer> hits = seen.get(h);
            if (hits != null) {
                // Check if the current substring matches any of 
                // the previous substrings with hash h.
                String cur = S.substring(start, start + L);
                for (Integer i : hits) {
                    String candidate = S.substring(i, i + L);
                    if (candidate.equals(cur)) {
                        return i;
                    }
                }
            }
            // Add the current substring's hashvalue and starting index to seen.
            seen.putIfAbsent(h, new ArrayList<Integer>());
            seen.get(h).add(start);
        }
        return -1;
    }
    
    public String longestDupSubstring(String s) {
        S = s;
        int n = S.length();
        
        // Convert string to array of integers to implement constant time slice
        int[] nums = new int[n];
        for (int i = 0; i < n; ++i) {
            nums[i] = (int)S.charAt(i) - (int)'a';
        }
        
        // Base value for the rolling hash function
        int a = 26;
        
        // modulus value for the rolling hash function to avoid overflow
        int modulus = 1_000_000_007;
        
        // Binary search, L = repeating string length
        int left = 1, right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (search(mid, a, modulus, n, nums) != -1) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        int start = search(left - 1, a, modulus, n, nums);
        return S.substring(start, start + left - 1);
    }
}