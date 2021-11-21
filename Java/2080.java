class RangeFreqQuery {
    Map<Integer, List<Integer>> pos;
 
    public RangeFreqQuery(int[] arr) {
        pos = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!pos.containsKey(arr[i])) {
                pos.put(arr[i], new ArrayList<>());
           }
            pos.get(arr[i]).add(i);
       }
   }
 
    public int query(int left, int right, int value) {
        if (!pos.containsKey(value)) {
            return 0;
       }
        List<Integer> p = pos.get(value);
        int start = bSearch2(p, left);
        int end = bSearch(p, right);
        return end - start + 1;
   }
 
    // 二分查找最后一个 <= value 的元素下标
    int bSearch(List<Integer> arr, int value) {
        if (arr.size() == 0 || value < arr.get(0)) {
            return -1;
       }
        int left = 0, right = arr.size() - 1;
        while (left + 1 < right) {
            int mid = (left + right) / 2;
            if (arr.get(mid) <= value) {
                left = mid;
           } else {
                right = mid;
           }
       }
        return arr.get(right) <= value ? right : left;
   }
 
    // 二分查找第一个 >= value 的元素下标
    int bSearch2(List<Integer> arr, int value) {
        if (arr.size() == 0 || arr.get(arr.size() - 1) < value) {
            return arr.size();
       }
        int left = 0, right = arr.size() - 1;
        while (left + 1 < right) {
            int mid = (left + right) / 2;
            if (arr.get(mid) < value) {
                left = mid;
           } else {
                right = mid;
           }
       }
        return arr.get(left) < value ? right : left;
   }
 }