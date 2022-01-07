//蓄水池抽样算法
class Solution {

    // 需要将链表传递给getRandom方法，所以只能提取作为类变量
    ListNode head;
    public Solution(ListNode head) {
        this.head = head;
    }
    
    public int getRandom() {
        // 定义一个变量，存储采样的结果值
        int result = 0;
        // 定义一个变量i，标记遍历到了第几个节点
        int i = 0;
        // 将当前链表head指针赋值给cur
        ListNode cur = head;
        // 循环遍历链表
        while (cur != null) {
            i++;
            // 取随机数rand 范围 [1, i]
            int rand = new Random().nextInt(i) + 1;
            // 因为rand最小值为1，这个边界只能取rand == 1
            if (rand == 1) {
                result = cur.val;
            }
            // 指针往后移动，遍历下一个节点
            cur = cur.next;
        }

        // 返回采样结果
        return result;
    }
}