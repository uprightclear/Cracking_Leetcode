class RangeFreqQuery {
    
    Map<Integer, List<Integer>> map = new HashMap();
    
    public RangeFreqQuery(int[] arr) {
        int n = arr.length;
        for(int i = 0; i < n; i++){
            if(!map.containsKey(arr[i]))
                map.put(arr[i], new ArrayList());
            map.get(arr[i]).add(i);
        }
    }
    
    public int query(int left, int right, int value) {
        List<Integer> A = map.get(value);
        if(A == null || left > A.get(A.size()-1) || right < A.get(0))
            return 0;
        
        int i = ceil(A, left), j = floor(A, right);        
        return j-i+1;
    }
    
    public int ceil(List<Integer> A, int x){
        int left = 0, right = A.size()-1; 
        if(x < A.get(0))
            return 0;
        
        while(left < right){
            int mid = (left+right)/2;
            if(A.get(mid) < x)
                left = mid + 1;
            else 
                right = mid;
        }
        return left;
    }
    
    public int floor(List<Integer> A, int x){
        int left = 0, right = A.size()-1; 
        if(x > A.get(right))
            return right;
        
        while(left < right){
            int mid = (left+right)/2+1;
            if(A.get(mid) > x)
                right = mid - 1;
            else 
                left = mid;
        }
        return left;
    }    
}