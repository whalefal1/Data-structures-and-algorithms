package ListCodes;

public class RotateRight {

    public static ListNode rotateRight(ListNode head, int k) {
        //健壮性判断
            if (k == 0 || head == null || head.next == null) {
                return head;
            }
            //统计链表长度
            int n = 1;
            ListNode iter = head;
            while (iter.next != null) {
                iter = iter.next;
                n++;
            }
            //计算新链表的最有一个节点
            int add = n - k % n;
            //如果为链表长度整数倍，则不动
            if (add == n) {
                return head;
            }
            //尾节点连接首节点
            iter.next = head;
            //移动指针，找到新链表头节点
            while (add-- > 0) {
                iter = iter.next;
            }
            ListNode ret = iter.next;
            iter.next = null;
            return ret;
        }
    }

