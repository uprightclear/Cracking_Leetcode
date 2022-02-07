class Bitset {
    boolean[] bits;
    boolean rev;
    int cnt;
    
    public Bitset(int size) {
        bits = new boolean[size];
        rev = false;
        cnt = 0;
    }
    
    public void fix(int idx) {
        if ((!rev && !bits[idx]) || (rev && bits[idx])) {
            cnt++;
            bits[idx] = !rev;
        }
    }
    
    public void unfix(int idx) {
        if ((!rev && bits[idx]) || (rev && !bits[idx])) {
            cnt--;
            bits[idx] = rev;
        }
    }
    
    public void flip() {
        rev = !rev;
        cnt = bits.length - cnt;
    }
    
    public boolean all() {
        return cnt == bits.length;
    }
    
    public boolean one() {
        return cnt > 0;
    }
    
    public int count() {
        return cnt;
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(boolean b : bits) {
            if(b == rev) sb.append('0');
            else sb.append('1');
        }
        return sb.toString();
    }
}

/**
 * Your Bitset object will be instantiated and called as such:
 * Bitset obj = new Bitset(size);
 * obj.fix(idx);
 * obj.unfix(idx);
 * obj.flip();
 * boolean param_4 = obj.all();
 * boolean param_5 = obj.one();
 * int param_6 = obj.count();
 * String param_7 = obj.toString();
 */