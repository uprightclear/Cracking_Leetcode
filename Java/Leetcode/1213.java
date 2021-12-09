//3 pointers
class Solution {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> ans = new ArrayList <>();
        // prepare three pointers to iterate through three arrays
        // p1, p2, and p3 point to the beginning of arr1, arr2, and arr3 accordingly
        int p1 = 0, p2 = 0, p3 = 0;

        while (p1 < arr1.length && p2 < arr2.length && p3 < arr3.length) {

            if (arr1[p1] == arr2[p2] && arr2[p2] == arr3[p3]) {
                ans.add(arr1[p1]);
                p1++;
                p2++;
                p3++;
            } else {
                if (arr1[p1] < arr2[p2]) {
                    p1++;
                } else if (arr2[p2] < arr3[p3]) {
                    p2++;
                } else {
                    p3++;
                }

            }
        }
        return ans;
    }
}

//brute force
class Solution {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> ans = new ArrayList<>();

        // note that HashMap won't work here as it does not guarantee the key orders
        Map<Integer, Integer> counter = new TreeMap<>();

        // iterate through arr1, arr2, and arr3 to count the frequencies
        for (Integer e: arr1) {
            counter.put(e, counter.getOrDefault(e, 0) + 1);
        }
        for (Integer e: arr2) {
            counter.put(e, counter.getOrDefault(e, 0) + 1);
        }
        for (Integer e: arr3) {
            counter.put(e, counter.getOrDefault(e, 0) + 1);
        }

        for (Integer item: counter.keySet()) {
            if (counter.get(item) == 3) {
                ans.add(item);
            }
        }
        return ans;

    }
}