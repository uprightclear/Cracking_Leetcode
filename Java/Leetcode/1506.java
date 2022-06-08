class Solution {
    public Node findRoot(List<Node> tree) {
        // Edge Case
        if (tree==null || tree.size()==0) return null;

        Set<Node> seen = new HashSet<>();

        // For each node in the tree
        for (Node node : tree){
            // For each child of the current node
            for (Node child : node.children)
                seen.add(child);
        }

        // For each node in the tree, if node doesn't exist in the set, return it as it's our root
        for (Node node : tree)
            if (!seen.contains(node)) return node;

        return null;
    }
}


class Solution {
    public Node findRoot(List<Node> tree) {
        // Edge Case
        if (tree==null || tree.size()==0) return null;

        long sum=0;

        // For each node in the tree
        for (Node node : tree){
            // Add current node value to sum
            sum+=node.val;

            // For each child - reduce value of child from sum
            for (Node child : node.children)
                sum-=child.val;
        }

        // Remaining value in sum is the only node that doesn't have a parent (meaning isn't a child of any other node) - which is the root.
        for (Node node : tree)
            if (node.val==sum) return node;

        return null;
    }
}


class Solution {
    public Node findRoot(List<Node> tree) {
        // Edge Case
        if (tree==null || tree.size()==0) return null;

        long sum=0;

        // For each node in the tree
        for (Node node : tree){
            // Add current node value to sum
            sum^=node.val;

            // For each child - reduce value of child from sum
            for (Node child : node.children)
                sum^=child.val;
        }

        // Remaining value in sum is the only node that doesn't have a parent (meaning isn't a child of any other node) - which is the root.
        for (Node node : tree)
            if (node.val==sum) return node;

        return null;
    }
}