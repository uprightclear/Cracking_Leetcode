class Solution {
    public int findKthNumber(int n, int k) {
        /*
        参考评论区郭郭的视频题解:
        本质是一个10叉树的先序遍历,找到按照先序遍历的第k个节点
        为什么是先序遍历?这个由字典序的性质决定:[1,10,100,1000,1001]
        假设相同位数的数字在10叉树的同一层上,那么就是先序遍历就是字典序排列
        从cur=1开始进行遍历,先计算的以cur为根的且<=n的节点个数nodes
            若nodes<=k,说明以cur开头的合格节点数不够,cur应该向右走:cur++
            若nodes>k,说明以cur开头的合格节点数足够,cur应该向下走:cur*=10
        */
        // 首先遍历以1开头大的数字
        // 由于cur可能会很大,因此int可能计算过程中会溢出,用long类型
        long cur = 1;
        // 因为1遍历了,因此k--
        k--;
        // 当且仅当k>0(还未遍历到第k个的时候)循环
        while(k > 0) {
            // 获取以cur开头的子节点合格(<=n)数目nodes
            int nodes = getNodes(n, cur);
            // 若nodes<=k的话说明把这nodes个节点分完都还没到k
            if(nodes <= k) {
                // cur向右走
                cur++;
                // 抵消掉nodes个节点
                k -= nodes;
            }else {
                // 若nodes>k的话说明把nodes个节点够分
                // cur往下走
                cur *= 10;
                // 将cur计算进k
                k--;
            }
        }
        // 最后cur会停留在第k小的数上
        return (int)cur;
    }

    /*
    计算[1,n]内以cur为根(开头)的节点个数
    */
    private int getNodes(int n, long cur) {
        // next表示cur右边的数,此时cur=10,next=11
        long next = cur + 1;
        // 统计合格的节点个数
        long totalNodes = 0;
        // 当cur<=n时可以进入循环
        while(cur <= n) {
            // 这里是最关键的一步:当n不在cur层时,该层有效节点数目为next - cur(全部都要了)
            // 当n在cur层时,该层有效节点数目为n - cur + 1(要一部分)
            // 统一起来就是取最小值
            totalNodes += Math.min(n - cur + 1, next - cur);
            // cur与next均向下计算
            cur *= 10;
            next *= 10;
        }
        return (int)totalNodes;
    }
}