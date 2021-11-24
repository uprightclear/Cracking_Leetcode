class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int times = minutesToTest / minutesToDie;
        int base = times + 1;
        // base ^ ans >= buckets 
        // ans >= log(buckets) / log(base)
        double temp = Math.log(buckets) / Math.log(base);
        int ans = (int)Math.ceil(temp);
        return ans;
    }
}