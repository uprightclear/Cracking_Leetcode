//序列化二叉树，是每一个子树都有唯一的序列化标识
//o(n^2) this is postorder
class Solution {
    Map<String, Integer> count;
    List<TreeNode> ans;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        count = new HashMap();
        ans = new ArrayList();
        collect(root);
        return ans;
    }

    public String collect(TreeNode node) {
        if (node == null) return "#";
        String serial = node.val + "," + collect(node.left) + "," + collect(node.right);
        count.put(serial, count.getOrDefault(serial, 0) + 1);
        if (count.get(serial) == 2)
            ans.add(node);
        return serial;
    }
}



//o(n)
class Solution {
    int curId = 1;
 
     public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
         Map<String, Integer> serialToId = new HashMap<>();
         Map<Integer, Integer> idToCount = new HashMap<>();
         List<TreeNode> res = new LinkedList<>();
         postorder(root, serialToId, idToCount, res);
         return res;
     }
     
     private int postorder(TreeNode root, Map<String, Integer> serialToId, Map<Integer, Integer> idToCount, List<TreeNode> res) {
         if (root == null) return 0;
         int leftId = postorder(root.left, serialToId, idToCount, res);
         int rightId = postorder(root.right, serialToId, idToCount, res);
         String curSerial = leftId + "," + root.val + "," + rightId;
         int serialId = serialToId.getOrDefault(curSerial, curId);
         if (serialId == curId) curId++;
         serialToId.put(curSerial, serialId);
         idToCount.put(serialId, idToCount.getOrDefault(serialId, 0) + 1);
         if (idToCount.get(serialId) == 2) res.add(root);
         return serialId;
     }
     
 }



//TLE
class Solution {
    List<TreeNode> ans;
    List<TreeNode> seen;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        ans = new ArrayList<>();
        seen = new ArrayList<>();
        TreeNode node = root;
        inorder(root);
        return ans;
    }
    
    public void inorder(TreeNode node) {
        if(node == null) return;
        inorder(node.left);
        if(!add(node, seen)) add(node, ans);
        inorder(node.right);        
    }
    
    public boolean add(TreeNode node, List<TreeNode> list) {
        for(TreeNode e : list) {
            if(isSame(e, node)) {
                return false;
            }
        }
        list.add(node);
        return true;
    }
    
    public boolean isSame(TreeNode a, TreeNode b) {
        if(a == null && b == null) return true;
        if(a == null || b == null) return false;
        if(a.val == b.val) return isSame(a.left, b.left) && isSame(a.right, b.right);
        return false;
    }
}