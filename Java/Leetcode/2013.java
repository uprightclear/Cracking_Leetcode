class DetectSquares {
    Map<Integer, Map<Integer, Integer>> cnt;

    public DetectSquares() {
        cnt = new HashMap<Integer, Map<Integer, Integer>>();
    }

    public void add(int[] point) {
        int x = point[0], y = point[1];
        cnt.putIfAbsent(y, new HashMap<Integer, Integer>());
        Map<Integer, Integer> yCnt = cnt.get(y);
        yCnt.put(x, yCnt.getOrDefault(x, 0) + 1);
    }

    public int count(int[] point) {
        int res = 0;
        int x = point[0], y = point[1];
        if (!cnt.containsKey(y)) {
            return 0;
        }
        Map<Integer, Integer> yCnt = cnt.get(y);
        Set<Map.Entry<Integer, Map<Integer, Integer>>> entries = cnt.entrySet();
        for (Map.Entry<Integer, Map<Integer, Integer>> entry : entries) {
            int col = entry.getKey();
            Map<Integer, Integer> colCnt = entry.getValue();
            if (col != y) {
                // 根据对称性，这里可以不用取绝对值
                int d = col - y;
                res += colCnt.getOrDefault(x, 0) * yCnt.getOrDefault(x + d, 0) * colCnt.getOrDefault(x + d, 0);
                res += colCnt.getOrDefault(x, 0) * yCnt.getOrDefault(x - d, 0) * colCnt.getOrDefault(x - d, 0);
            }
        }
        return res;
    }
}

// 先考虑如何实现 int count(int[] point)，记输入的 \textit{point}point 的横纵坐标分别为 xx 和 yy。则形成的正方形的上下两条边中，其中一条边的纵坐标为 yy， 我们枚举另一条边的纵坐标为 colcol，则正方形的边长 dd 为 |y - col|∣y−col∣ 且大于 00。有了其中一个点的坐标 (x, y)(x,y) 和一条横边的纵坐标 colcol，我们可以得到正方形的四个点的坐标分别为 (x, y)(x,y)，(x, col)(x,col)，(x+d, y)(x+d,y)，(x+d, col)(x+d,col) 或 (x, y)(x,y)，(x, col)(x,col)，(x-d, y)(x−d,y)，(x-d, col)(x−d,col)。

// 据此，我们可以用一个哈希表来存储 void add(int[] point) 函数中加入的点。先把点按照行来划分，键为行的纵坐标，值为另一个哈希表，其中键为该行中的点的横坐标，值为这样的点的个数。因为点会重复出现，所以计算正方形的个数时需要把另外三个坐标出现的次数相乘。



//better easy understand solution
// https://leetcode.com/problems/detect-squares/discuss/1471958/C%2B%2BJavaPython-2-approaches-using-HashMap-with-Picture-Clean-and-Concise
class DetectSquares { // 128 ms, faster than 60.00%
    int[][] cntPoints = new int[1001][1001];
    List<int[]> points = new ArrayList<>();

    public void add(int[] p) {
        cntPoints[p[0]][p[1]] += 1;
        points.add(p);
    }

    public int count(int[] p1) {
        int x1 = p1[0], y1 = p1[1], ans = 0;
        for (int[] p3 : points) {
            int x3 = p3[0], y3 = p3[1];
            if (Math.abs(x1-x3) == 0 || Math.abs(x1-x3) != Math.abs(y1-y3))
                continue; // Skip empty square or invalid square point!
            ans += cntPoints[x1][y3] * cntPoints[x3][y1];
        }
        return ans;
    }
}