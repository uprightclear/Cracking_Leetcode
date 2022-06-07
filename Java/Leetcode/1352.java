class ProductOfNumbers {
    List<Integer> prefix = new ArrayList<>();
    
    public ProductOfNumbers() {
        prefix.add(1);
    }
    
    public void add(int num) {
        if(num > 0) {
            prefix.add(prefix.get(prefix.size() - 1) * num);
        } else {
            prefix = new ArrayList<>();
            prefix.add(1);
        }
    }
    
    public int getProduct(int k) {
        int n = prefix.size();
        return k < n ? prefix.get(n - 1) / prefix.get(n - k - 1) : 0;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */



//TLE
class ProductOfNumbers {
    List<Integer> list;
    public ProductOfNumbers() {
        list = new ArrayList<>();
    }
    
    public void add(int num) {
        list.add(num);
    }
    
    public int getProduct(int k) {
        int sum = 1;
        for(int i = list.size() - 1; i >= list.size() - k; i--) {
            int cur = list.get(i);
            if(cur == 0) return 0;
            sum *= cur;
        }
        return sum;
    }
}