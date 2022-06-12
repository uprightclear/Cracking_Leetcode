class FileSystem {

    Map<String, Integer> file = new HashMap<>(); 
    
    public FileSystem() {
        file.put("", -1);
    }
    
    public boolean createPath(String path, int value) {
        int idx = path.lastIndexOf("/");
        String parent = path.substring(0, idx);
        if (!file.containsKey(parent)) return false; 
        return file.putIfAbsent(path, value) == null;   
    }
    
    public int get(String path) {
        return file.getOrDefault(path, -1);
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */



class FileSystem {
    class File{
        String name;
        int val = -1;
        Map<String, File> map = new HashMap<>();
        
        File(String name){
            this.name = name;
        }
    }
    File root;
    public FileSystem() {
        root = new File("");
    }
    
    public boolean create(String path, int value) {
        String[] array = path.split("/");
        File cur = root;
        
        for(int i = 1; i < array.length; i++){
            String cur_name = array[i];
            if(cur.map.containsKey(cur_name) == false){
                if(i == array.length - 1){
                    cur.map.put(cur_name, new File(cur_name));
                }else{
                    return false;
                }
            }
            cur = cur.map.get(cur_name);
        }
        
        if(cur.val != -1){
            return false;
        }
        
        cur.val = value;
        return true;
    }
    
    public int get(String path) {
        String[] array = path.split("/");
        File cur = root;
        for(int i = 1; i < array.length; i++){
            String cur_name = array[i];
            if(cur.map.containsKey(cur_name) == false){
                return -1;
            }
            cur = cur.map.get(cur_name);
        }
        
        return cur.val;
        
        
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.create(path,value);
 * int param_2 = obj.get(path);
 */