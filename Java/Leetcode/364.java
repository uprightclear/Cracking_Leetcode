/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */

 //DFS
class Solution {
    int index = 0;
    int max = 0;
    public int depthSumInverse(List<NestedInteger> nestedList) {
        List<Integer> depths = new ArrayList<>();
        List<Integer> values = new ArrayList<>();
        int sum = 0;
        for(int i = 0; i < nestedList.size(); i++){
            getdepth(nestedList.get(i), depths, index, 1,values);
        }

        for(int i : depths){
            max = Math.max(i,max);
        }
        int[] weight = new int[depths.size()];
        for(int i = 0; i < depths.size(); i++){
            weight[i] = max - depths.get(i)+1;
        }

        for(int i = 0; i < weight.length; i++){
            sum+=weight[i] *values.get(i);
        }

        return sum;

    }
    public void getdepth(NestedInteger nestedint, List<Integer> depths, int index, int depth,List<Integer> values){
       if(nestedint.isInteger()){
           depths.add(index,depth);
           values.add(index,nestedint.getInteger());
           return;
       }
       depth++;
       List<NestedInteger> list = nestedint.getList();
       for(int i = 0; i < list.size(); i++){
           getdepth(list.get(i),depths,index++,depth,values);
       }
    }
}

//BFS
public int depthSumInverse(List<NestedInteger> nestedList) {
    Queue<NestedInteger> queue = new LinkedList<>(nestedList);
    int levelWeight = 0; // each time an element is encountered, add the value
    int overAllWeight = 0; // as depth increases, this variable will add the previous depth elements AGAIN 
    
	// BFS
    while(!queue.isEmpty()) {
        int size = queue.size(); 
        for(int i = 0; i < size; i++) {
            NestedInteger obj = queue.poll();
            if(obj.isInteger()) {
                levelWeight += obj.getInteger(); // do not make it ZERO (0)
            } else {
                queue.addAll(obj.getList());
            }
        }
        
        overAllWeight += levelWeight; 
    }
    
    return overAllWeight;
}