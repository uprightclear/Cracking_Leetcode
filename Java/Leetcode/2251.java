class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int[] sortedPeople = Arrays.copyOf(people, people.length);
        Arrays.sort(sortedPeople);
        
        Arrays.sort(flowers, (a, b) -> Arrays.compare(a, b));
        Map<Integer, Integer> dic = new HashMap();
        PriorityQueue<Integer> heap = new PriorityQueue();
        
        int i = 0;
        for (int person : sortedPeople) {
            while (i < flowers.length && flowers[i][0] <= person) {
                heap.add(flowers[i][1]);
                i++;
            }
            
            while (!heap.isEmpty() && heap.peek() < person) {
                heap.remove();
            }
            
            dic.put(person, heap.size());
        }
        
        int[] ans = new int[people.length];
        for (int j = 0; j < people.length; j++) {
            ans[j] = dic.get(people[j]);
        }
        
        return ans;
    }
}


class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int[] sArr = new int[flowers.length];
        int[] eArr = new int[flowers.length];
        int index = 0;
        for(int[] flower : flowers) {
            int s = flower[0];
            int e = flower[1];
            sArr[index] = s;
            eArr[index++] = e + 1;
        }
        Arrays.sort(sArr);
        Arrays.sort(eArr);
        for(int i = 0; i < people.length; i++) {
            int start = bs(sArr, people[i]);
            int end = bs(eArr, people[i]);
            people[i] = start - end;
        }
        return people;
    }

    public int bs(int[] arr, int target) {
        int l = 0, r = arr.length;
        while(l < r) {
            int mid = l + (r - l) / 2;
            if(arr[mid] <= target) l = mid + 1;
            else r = mid;
        }
        return l;
    }
}
