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