class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0, right = arr.length - k;
        while (left < right) {
            int mid = (left + right) / 2;
            if (x - arr[mid] > arr[mid + k] - x)
                left = mid + 1;
            else
                right = mid;
        }
        List<Integer> res = new ArrayList<>();
        for(int i = left; i < left + k; i++) res.add(arr[i]);
        return res;
    }
}



class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            return Math.abs(b - x) == Math.abs(a - x) ? b - a : Math.abs(b - x) - Math.abs(a - x);
        });
        for(int i : arr) {
            pq.offer(i);
            if(pq.size() > k) pq.poll();
        }
        List<Integer> ans = new ArrayList<>();
        while(!pq.isEmpty()) {
            ans.add(pq.poll());
        }
        Collections.sort(ans);
        return ans;
    }
}


class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        int start = 0;
        int end = arr.length - 1;
        while (end - start >= k) {
            if (Math.abs(arr[start] - x) > Math.abs(arr[end] - x)) {
                start++;
            } else {
                end--;
            }
        }

        List<Integer> result = new ArrayList<>(k);
        for (int i = start; i <= end; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}