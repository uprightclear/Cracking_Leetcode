public class Solution extends Reader4 {
    public int read(char[] buf, int n) {
        int copiedChars = 0, readChars = 4;
        char[] buf4 = new char[4];
        
        while (copiedChars < n && readChars == 4) {
            readChars = read4(buf4);
            
            for (int i = 0; i < readChars; ++i) {
                if (copiedChars == n)
                    return copiedChars;
                buf[copiedChars] = buf4[i];
                ++copiedChars;    
            }    
        }
        return copiedChars;
    }
}