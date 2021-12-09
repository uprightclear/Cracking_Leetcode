class TimeMap {

    private Map<String, List<Object[]>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        List<Object[]> list = map.getOrDefault(key, new ArrayList<Object[]>());
        list.add(new Object[]{value, timestamp});
        if(!map.containsKey(key)) map.put(key, list);
    }
    
    public String get(String key, int timestamp) {
        if(map.containsKey(key)){
            List<Object[]> list = map.get(key);
            int l = 0,  r = list.size() - 1;
            while(l < r){
                int mid = l + (r - l + 1) / 2;
                int timestamp_prev  = (int)list.get(mid)[1];
                if(timestamp_prev <= timestamp) l = mid;
                else r = mid - 1;
            }
            if(l == 0 && (int)list.get(0)[1] > timestamp) return "";
            else return (String)list.get(l)[0];
        }
        return "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */