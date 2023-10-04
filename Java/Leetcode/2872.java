class Solution {
    private int count = 0;
    private int k;

    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        this.k = k;
        
        // build the tree
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(values[i]);
        }

        for (int[] edge : edges) {
            Node a = nodes[edge[0]];
            Node b = nodes[edge[1]];
            a.neighbors.add(b);
            b.neighbors.add(a);
        }

        // visit the tree from the root
        getSum(nodes[0], null);
        return count;

    }

    // returns the sum of the subtree rooted at node
    private int getSum(Node node, Node parent){
        int sum = node.value;
        for (Node neighbor : node.neighbors) {
            if(neighbor == parent) continue;
            sum += getSum(neighbor, node);
        }

        if(sum %k == 0){
            count++;
            return 0;
        }
        return sum;
    }


    private static class Node{
        int value;
        List<Node> neighbors = new ArrayList<>();

        public Node(int value) {
            this.value = value;
        }
    }
}