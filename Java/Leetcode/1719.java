class Solution {
    public int checkWays(int[][] pairs) {
        int ans = 1;
        HashMap<Integer,List<Integer>> graph = new HashMap<Integer, List<Integer>>();
        HashMap<Integer, Integer> map = new HashMap<>();
        // 构建邻接矩阵
        for (int[] p : pairs){
            map.put(p[0], map.getOrDefault(p[0], 0) + 1);
            map.put(p[1], map.getOrDefault(p[1], 0) + 1);
            graph.computeIfAbsent(p[0], t -> new ArrayList<Integer>()).add(p[1]);
            graph.computeIfAbsent(p[1], t -> new ArrayList<Integer>()).add(p[0]);

        }
        int n = map.size();
        // 下面这段排序属实不雅观，码力不够，如果有大佬能帮我提提建议将不胜感谢！
        Integer[] nums = new Integer[n];
        int y = 0;
        for (Integer x : map.keySet()){
            nums[y++] = x;
        }
        Arrays.sort(nums, new Comparator<Integer>(){
            //@override
            public int compare(Integer a, Integer b){
                return map.get(b) - map.get(a);
            }
        });
        // 根节点不满足条件
        if(map.get(nums[0]) != n - 1) return 0;
        // 判断有没有称为多个子树的潜质。
        for(int[] p : pairs){
            //如果是基本数据类型，==判断的是值；如果是对象类型，==判断的是对象的地址。这里坑了我一会
            if (Objects.equals(map.get(p[1]), map.get(p[0]))){ // 某一对具有祖孙关系的节点的 祖孙复杂关系也一样，说明可以交换
                ans = 2;
                break;
            }
        }
        HashSet<Integer> vis = new HashSet<>(); // 存放已经是祖先节点的
        HashMap<Integer, Integer> fa = new HashMap<>(); // 维护每个节点的实时父节点
        for(int i : nums){
            fa.put(i, nums[0]); // 初始下，全部节点都连接在根节点下
        }
        vis.add(nums[0]);
        
        for(int i = 1; i < n; i++){
            for (int j : graph.get(nums[i])){ // 找到nums[i]这个节点的邻接
                if(!vis.contains(j)){ // vis不包含说明是当前nums[i]节点的孙节点
                    //!!! 这个条件是核心！！！ 
                    // 简单概括就是，如果a的祖先不是b的祖先，但是a,b之间还存在祖孙关系，这显然不合理。
                    if(fa.get(j) != fa.get(nums[i])){
                        return 0; // 父节点不一致，说明矛盾。具体原因参见 树叶烦 的解析
                    }
                    fa.put(j, nums[i]); // 更新父节点
                }
            }
            vis.add(nums[i]); // 这个节点已经安排清楚了，加入祖先节点
        }
        return ans;
    }
}