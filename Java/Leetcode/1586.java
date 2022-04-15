class BSTIterator {
    Stack<TreeNode> nextStack = new Stack<>();
    Stack<TreeNode> prevStack = new Stack<>();
    Set<TreeNode> visited = new HashSet<>();

    public BSTIterator(TreeNode root) {
        fillInNextStack(root);
    }

    public boolean hasNext() {
        return !nextStack.isEmpty();
    }

    public int next() {
        TreeNode node = nextStack.pop();
        if(!visited.contains(node) && node.right != null) {
            fillInNextStack(node.right);
        }
        visited.add(node);
        prevStack.push(node);
        return node.val;
    }

    public boolean hasPrev() {
        return !prevStack.isEmpty() && prevStack.size() > 1;
    }

    public int prev() {
        nextStack.push(prevStack.pop());
        return prevStack.peek().val;
    }

    private void fillInNextStack(TreeNode node) {
        while(node != null) {
            nextStack.push(node);
            node = node.left;
        }
    }
}