//brute force Time Limit Exceeded
class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int ans = 0;
        int len = time.length;
        for(int i = 0; i < len; i++) {
            for(int j = i + 1; j < len; j++) {
                if((time[i] + time[j]) % 60 == 0) ans++;
            }
        }
        return ans;
    }
}

//Use an Array to Store Frequencies
//https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/solution/
class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int remainders[] = new int[60];
        int count = 0;
        for (int t: time) {
            if (t % 60 == 0) { // check if a%60==0 && b%60==0
                count += remainders[0];
            } else { // check if a%60+b%60==60
                count += remainders[60 - t % 60];
            }
            remainders[t % 60]++; // remember to update the remainders
        }
        return count;
    }
}