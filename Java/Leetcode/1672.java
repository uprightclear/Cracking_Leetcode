//ez
class Solution {
    public int maximumWealth(int[][] accounts) {
        int maxWealthSoFar = 0;
        for (int[] account : accounts) {
            int currCustomerWealth = 0;
            for (int money : account) currCustomerWealth += money;
            maxWealthSoFar = Math.max(maxWealthSoFar, currCustomerWealth);
        }
        return maxWealthSoFar;
    }
}