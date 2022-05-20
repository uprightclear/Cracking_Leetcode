public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
    
    // Store process tree as an adjacency list
    Map<Integer, List<Integer>> adjacencyLists = new HashMap<>();
    for (int i = 0; i < ppid.size(); i++) {
        adjacencyLists.putIfAbsent(ppid.get(i), new LinkedList<>());
        adjacencyLists.get(ppid.get(i)).add(pid.get(i));
    }
    
    // Kill all processes in the subtree rooted at process "kill"
    List<Integer> res = new LinkedList<>();
    Stack<Integer> stack = new Stack<>();
    stack.add(kill);
    while (!stack.isEmpty()) {
        int cur = stack.pop();
        res.add(cur);
        List<Integer> adjacencyList = adjacencyLists.get(cur);
        if (adjacencyList == null) continue;
        stack.addAll(adjacencyList);
    }
    return res;   
}