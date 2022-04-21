class MyHashSet {
    List<Integer> list;
    public MyHashSet() {
        list = new ArrayList<>();
    }
    
    public void add(int key) {
        if(list.indexOf(key) >= 0) return;
        list.add(key);
    }
    
    public void remove(int key) {
        int index = list.indexOf(key);
        if(index >= 0) list.remove(index);
    }
    
    public boolean contains(int key) {
        return list.indexOf(key) >= 0;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */