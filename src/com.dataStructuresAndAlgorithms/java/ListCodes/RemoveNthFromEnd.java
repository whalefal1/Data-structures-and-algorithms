package ListCodes;
/*
删除倒数第n个节点
虚拟头节点方法
 */
public class RemoveNthFromEnd {
    public ListNode solution(ListNode head,int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fast = dummy;        //因为题目要求倒数第n个，所以定义快慢指针
        ListNode slow = dummy;        //快指针先走n步后，快慢指针再同时前进
        for (int i = 0; i < n; i++) {        //当快指针走到链表的最后时，慢指针刚好到达倒数第n个节点
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
