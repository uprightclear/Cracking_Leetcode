class Solution {
    public boolean isRectangleCover(int[][] r) {
       //只有4个奇数次出现的坐标/
       // 面积相等
       int left = Integer.MAX_VALUE;
       int right = Integer.MIN_VALUE;
       int top = Integer.MIN_VALUE;
       int bottom = Integer.MAX_VALUE;
       int n = r.length;

       Set<String>set = new HashSet<>();
       int sum = 0; // 小矩形相加
       for(int i  =  0; i < n; i++){
           int[] t = r[i];
           //获得四个点坐标
           left = Math.min(left, t[0]);
           bottom = Math.min(bottom, t[1]);
           right = Math.max(right, t[2]);
           top = Math.max(top, t[3]);
           //计算小矩形面积
           sum += (caculateArea(t[0], t[1], t[2], t[3]));
           //记录坐标
           String [] strings = new String[4];
           // 左下顶点坐标
           strings[0] = merge(t[0], t[1]);
           strings[1] = merge(t[0], t[3]);
           strings[2] = merge(t[2], t[1]);
           strings[3] = merge(t[2], t[3]);
           for(int j = 0; j < 4; j++){
               if(set.contains(strings[j]))set.remove(strings[j]);
               else set.add(strings[j]);
           }
       }
       if(set.size() == 4 && 
           set.contains(merge(left, top)) &&
           set.contains(merge(left, bottom)) &&
           set.contains(merge(right, top))&&
           set.contains(merge(right, bottom))
       ){
           return sum == caculateArea(left, bottom, right, top);
       }
       return false;
    }
    int caculateArea(int left, int bottom, int right, int top){
        return (top - bottom) * (right - left);
    }
    String merge(int a, int b){
        return a + " " + b;
    }
}