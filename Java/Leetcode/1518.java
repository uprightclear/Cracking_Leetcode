//simulate
class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int ans = numBottles;
        while(numBottles / numExchange >= 1) {
            ans += numBottles / numExchange;
            numBottles = numBottles - (numBottles / numExchange) * (numExchange - 1);
        }
        return ans;
    }
}