class Solution {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int len = plants.length;
        int a = 0, b = len - 1;
        int wa = capacityA, wb = capacityB;
        int ans = 0;
        while(a <= b) {
            if(wa >= plants[a]) {
                wa -= plants[a];
                a++;
            } else if (a == b && wb >= plants[b]) {
                wb -= plants[b];
                b--;
            } else {
                wa = capacityA - plants[a]; 
                ans++;
                a++;
            }
            
            
            if(a <= b) {
                if(wb >= plants[b]) wb -= plants[b];
                else {
                    wb = capacityB - plants[b]; 
                    ans++;
                }
                b--;
            }
        }
        return ans;
    }
}