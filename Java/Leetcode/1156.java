class Solution {
    public int maxRepOpt1(String text) {        
        
        int[] freq = new int[26];
        
        for(char c: text.toCharArray()){
            freq[c - 'a']++;
        }
        
        int max = 1;
        int i = 0;
        while(i < text.length()){
            char currChar = text.charAt(i); // we want to find a substring that only contains this character
            
            int firstDiff = i; // find the index of the first character that's different from currChar, if there's any
            while(firstDiff < text.length() && currChar == text.charAt(firstDiff)){
                firstDiff++;                
            }
            
            // skip the first different character and see how far we can reach before we run into another character that's not currChar
            int r = firstDiff + 1;           
            while(r < text.length() && text.charAt(r) == currChar){
                r++;
            }
            
            // determine the length of the longest substring we can form that only contains currChar after using our swap
            int windowSize = 0;
            if(freq[currChar-'a'] >= r - i){ 
                // we have at least one extra available currChar to swap with the character at firstDiff 
                // e.g.   aaaabaacca:    
                // index: 0123456789       i = 0, firstDiff = 4, r = 7, freq['a'-'a'] = 7,
                //                         freq['a'-'a'] == r - i, we have exactly one extra 'a' at index 9 to swap with 'b' at index 4 to 
                //                         form a substring of length 7 that only contains 'a'.
                windowSize = r - i;
            } else{ 
                // we don't have extra currChar to swap with the character at firstDiff 
                // e.g.   aaaabaaccc:    
                // index: 0123456789       i = 0, firstDiff = 4, r = 7, freq['a'-'a'] = 6,
                //                         freq['a'-'a'] < r - i, we don't have any extra 'a' to swap with 'b' at index 4 to 
                //                         form a substring of length 7 that only contains 'a'. Therefore, we have to swap 'a' at
                //                         index (r - 1 = 6) with the 'b' at index 4. This results in a substring of length 6 (r - i - 1).
                windowSize = r - i - 1;
            }
            
            max = Math.max(max, windowSize);
            i = firstDiff;
        }
        
        return max;
    }
}