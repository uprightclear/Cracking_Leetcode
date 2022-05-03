class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        int n = recipes.length;
        List<String> res = new ArrayList<>();
        
        Map<String, List<String>> sup2recipe = new HashMap<>();
        Map<String, Integer> indegree = new HashMap<>();
        
        for(int i = 0; i < n; i++) {
            String recipe = recipes[i];
            for(String ing : ingredients.get(i)) {
                sup2recipe.putIfAbsent(ing, new ArrayList<>());
                sup2recipe.get(ing).add(recipe);
                indegree.put(recipe, indegree.getOrDefault(recipe, 0) + 1);
            }
        }
        
        Queue<String> q = new LinkedList<>();
        for(String sup : supplies) q.offer(sup);
        
        while(!q.isEmpty()) {
            String sup = q.poll();
            for(String y : sup2recipe.getOrDefault(sup, new ArrayList<>())) {
                indegree.put(y, indegree.get(y) - 1);
                if(indegree.get(y) == 0) {
                    q.offer(y);
                    res.add(y);
                }
            }
        }
        
        return res;
    }
}