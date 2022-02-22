class Solution {
    public int fixedPoint(int[] arr) {
        int n = arr.length;
        int low = 0, high = n - 1;
        while(low < high) {
            int mid = (low + high) / 2;
            if(arr[mid] - mid >= 0) high = mid;
            else low = mid + 1;
        }
        return arr[low] == low ? low : -1;
    }
}