class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int root = findRoot(n, leftChild, rightChild);
        if(root == -1) return false;

        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            int node = queue.poll();
            if(node == -1) continue;
            if(!visited.add(node)) return false;
            int left = leftChild[node];
            int right = rightChild[node];

            queue.offer(left);
            queue.offer(right);
        }
        return visited.size() == n;
    }

    public int findRoot(int n, int[] left, int[] right) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++) set.add(i);
        for(int node : left) set.remove(node);
        for(int node : right) set.remove(node);
        return set.size() == 1 ? set.iterator().next() : -1;
    }
}