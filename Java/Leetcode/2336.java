class SmallestInfiniteSet {
    Set<Integer> deleted;
    int cur = 1;
    public SmallestInfiniteSet() {
        deleted = new HashSet<>();
    }
    
    public int popSmallest() {
        deleted.add(cur);
        int tmp = cur;
        while(deleted.contains(++cur));
        return tmp;
    }
    
    public void addBack(int num) {
        if(deleted.contains(num)) {
            deleted.remove(num);
            cur = Math.min(cur, num);
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */