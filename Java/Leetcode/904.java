class Solution {
    public int totalFruit(int[] tree) {
        int max = 0, count = 0;
        for (int i = 0, first = 0, second = -1; i < tree.length; i++) {
            count++;
            if (tree[i] == tree[first]) {
                first = i;
            } else if (second == -1 || tree[i] == tree[second]) {
                second = i;
            } else {
                max = Math.max(count - 1, max);
                count = Math.abs(first - second) + 1;
                first = i - 1;
                second = i;
            }
        }
        return Math.max(count, max);
    }
}

class Solution {
    public int totalFruit(int[] tree) {
        Map<Integer, Integer> count = new HashMap<>();
        int i = 0, j;
        for (j = 0; j < tree.length; j++) {
            count.put(tree[j], count.getOrDefault(tree[j], 0) + 1);
            if (count.size() > 2) {
                count.put(tree[i], count.get(tree[i]) - 1);
                count.remove(tree[i++], 0);
            }
        }
        return j - i;
    }
}

//sliding window that is easy to understand
class Solution {
    public int totalFruit(int[] tree) {
        int begin = 0, end = 0, type = 0, len = 0; 
        Map<Integer, Integer> map = new HashMap<>();
        while (end < tree.length) {
            int in = tree[end++]; // new character gets in from string right. 
            if (map.getOrDefault(in, 0) == 0) type++;
            map.put(in, map.getOrDefault(in, 0) + 1);
            while (type > 2) {
                int out = tree[begin++]; // old character gets out from string left.
                //if the value that being replaced == 1
                if (map.put(out, map.get(out) - 1) == 1) type--; 
            }
            len = Math.max(len, end - begin); 
        }
        return len; 
    }
}

class Solution {
    public static int totalFruit(int[] fruits) {
        int length = fruits.length;
        //长度小于3，直接返回长度
        if (length < 3) return length;
        //  篮子一       篮子二       篮子一数量  篮子二数量  最大总数      左指针
        int type1 = -1, type2 = -1, num1 = 0, num2 = 0, result = 0, left = 0;
        //i为右指针
        for (int i = 0; i < length; i++) {
            //初始化type1
            if (type1 == -1) {
                type1 = fruits[i];
                num1++;
            //初始化type2
            } else if (type2 == -1 && type1 != fruits[i]) {
                type2 = fruits[i];
                num2++;
            //与篮子一相同，篮子一数量加一
            } else if (type1 == fruits[i]) {
                num1++;
            //与篮子二相同，篮子二数量加一
            } else if (type2 == fruits[i]) {
                num2++;
            } else {
                //都不相同情况
                //与之前相比是否更大，是则替换
                result = Math.max(num1 + num2, result);
                //从左指针开始，从篮子拿出果子，直到有一个篮子清空
                for (int j = left; j < i; j++) {
                    if (fruits[j] == type1) {
                        num1--;
                    } else {
                        num2--;
                    }
                    //有篮子清空时，更新左指针、果子种类和数量
                    if (num1 == 0) {
                        left = j + 1;
                        type1 = fruits[i];
                        num1 = 1;
                        break;
                    } else if (num2 == 0) {
                        left = j + 1;
                        type2 = fruits[i];
                        num2 = 1;
                        break;
                    }
                }
            }
        }
        return Math.max(num1 + num2, result);
    }
}