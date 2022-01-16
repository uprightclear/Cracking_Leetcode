class Solution {
    public int maxDistToClosest(int[] seats) {
        int len = seats.length;
        //prev: the prev person
        //future: the next person
        int prev = -1, future = 0;
        int ans = 0;
        
        for(int i = 0; i < len; i++) {
            if(seats[i] == 1) prev = i;
            else {
                while(future < len && seats[future] == 0 || future < i) future++;
                
                int left = prev == -1 ? len : i - prev;
                int right = future == len ? len : future - i;
                ans = Math.max(ans, Math.min(left, right));
            }
        }
        return ans;
    }
}