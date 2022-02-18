class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> ret = new ArrayList<Integer>();
        for (int n = arr.length; n > 1; n--) {
            int index = 0;
            //find the max index makes arr[index] the largest from 0 ~ n - 1
            for (int i = 1; i < n; i++) {
                if (arr[i] >= arr[index]) {
                    index = i;
                }
            }
            if (index == n - 1) {
                continue;
            }
            reverse(arr, index);
            reverse(arr, n - 1);
            ret.add(index + 1);
            ret.add(n);
        }
        return ret;
    }

    public void reverse(int[] arr, int end) {
        for (int i = 0, j = end; i < j; i++, j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}