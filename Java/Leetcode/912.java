class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }
    public void quickSort(int[] arr,int i, int j){
       if (i < j) {
			int p = partition(arr, i, j); 
            // p is fixed and call quickSort again for left and right array
			quickSort(arr, i, p-1); 
			quickSort(arr, p+1, j); 
		}
    }
    public int partition(int[] arr,int low,int high) {
        // In worst case it will be o(n^2). i.e. if data is already sorted
		// we can improve it by using middle element as pivot and then before starting
		// anything just swap it with high. so, that high will remain pivot.

		// Find mid of the array
		int mid = (low + high) / 2;
		// swap array element present in mid and high index
		swapIntArray(arr, mid, high);
		// now pivot is high again.
		// we goes from low till high-1 because high is reserved for pivot
		for (int j = low; j < high; j++) {
			if (arr[j] < arr[high]) {
				swapIntArray(arr, j, low);
				low++;
			}
		}
		// when j reached high,we know that low is in pivot position. so we just swap it
		swapIntArray(arr, high, low);
		return low;
    }
    private void swapIntArray(int[] a, int i,int j){
        int temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
}

//7 Sorting Algo: https://leetcode.com/problems/sort-an-array/solutions/492042/7-sorting-algorithms-quick-sort-top-down-bottom-up-merge-sort-heap-sort-etc/?languageTags=java 