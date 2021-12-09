class Solution {
    public int wateringPlants(int[] plants, int capacity) {
        int ans = 0;
        int sum = capacity;
        for(int i = 0; i < plants.length; i++) {
            if(sum < plants[i]) {
                ans += i * 2;
                sum = capacity;
            }
            ans++;
            sum -= plants[i];
        }
        return ans;
    }
}