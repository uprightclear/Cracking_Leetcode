public class String_Similarities {
    public static void getZ(String str, int n, int Z[]) {
        int l, r, k;
        l = r = 0;

        for(int i = 1; i < n; i++) {
            if(i > r) {
                l = r = i;
                while(r < n && str.charAt(r - l) == str.charAt(r)) r++;
                Z[i] = r - l;
                r--; 
            } else {
                k = i - l;

                if(Z[k] < r - i + 1) {
                    Z[i] = Z[k];
                } else {
                    l = i;
                    while(r < n && str.charAt(r - l) == str.charAt(r)) r++;
                    Z[i] = r - l;
                    r--; 
                }
            }
        }
    }

    // Function to return the similarity sum
    public static int sumSimilarities(String s, int n)
    {
        int Z[] = new int[n] ;

        // Compute the Z-array for the given string
        getZ(s, n, Z);

        int total = n;

        // Summation of the Z-values
        for (int i = 1; i < n; i++)
            total += Z[i];

        return total;
    }

    // Driver code
    public static void main(String []args)
    {
        String s = "ababa";
        int n = s.length();

        System.out.println(sumSimilarities(s, n));
    }


}
