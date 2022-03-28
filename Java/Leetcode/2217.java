class Solution {
    public long[] kthPalindrome(int[] queries, int intLength) {
        long[] result = new long[queries.length];
        int i = 0;
        for(int num: queries){
			long half = (intLength + 1) / 2; //half for 3 = 2, half for 4 = 2
			long start = (long)Math.pow(10, half - 1);
			long end = (long)Math.pow(10, half) - 1;
			if(num <= (end - start + 1)){ //check if query is within range
				String firstHalfOfPalindrome = (start + num - 1) + "";
				String secondHalf = (new StringBuilder(firstHalfOfPalindrome)).reverse().toString();
				result[i++] = Long.parseLong(firstHalfOfPalindrome + secondHalf.substring(intLength % 2)); 
			}else{
				result[i++] = -1;
			}
        }
        return result;
    }
}