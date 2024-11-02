package ListCodes;
/*
判断是否含有环型链表
 */
public class DetectCycle {
    public ListNode solution(ListNode head){
        ListNode slow = head;                          //定义快慢指针，快指针的速度是慢指针的两倍
        ListNode fast = head;
        while (fast != null && fast.next != null) {//着重注意遍历链表的方法
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {                               // 有环
                ListNode index1 = fast;
                ListNode index2 = head;
                // 两个指针，从头结点和相遇结点，各走一步，速度相等都为一，直到相遇，相遇点即为环入口
                while (index1 != index2) {
                    index1 = index1.next;
                    index2 = index2.next;
                }
                return index1;
            }
        }
        return null;
    }
}
