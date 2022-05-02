class Solution {
    public int minimumCardPickup(int[] cards) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < cards.length; i++) {
            if(!map.containsKey(cards[i])) map.put(cards[i], i);
            else {
                ans = Math.min(ans, i - map.get(cards[i]) + 1);
                map.put(cards[i], i);
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}