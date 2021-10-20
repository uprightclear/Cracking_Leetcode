//binary search
// 链接：https://leetcode-cn.com/problems/capacity-to-ship-packages-within-d-days/solution/gong-shui-san-xie-li-yong-er-duan-xing-z-95zj/

class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int max = 0, sum = 0;
        for(int weight : weights) {
            max = Math.max(max, weight);
            sum += weight;
        }
        
        int l = max, r = sum;
        while(l < r) {
            int mid = l + r >> 1;
            if(check(weights, mid, days)) {
                r = mid;
            }else {
                l = mid + 1;
            }
        }
        return r;
    }
    
    private boolean check(int[] weights, int cap, int days) {
        int n = weights.length;
        int count = 0;
        for(int i = 1, sum = weights[0]; i < n; sum = 0, count++) {
            while(i < n && sum + weights[i] <= cap) {
                sum += weights[i];
                i++;
            }
        }
        return count <= days;
    }
}