package ListCodes;
/*
交换相邻节点——虚拟头节点方法
 */
public class SwapPairs {
    public ListNode solution(ListNode head){
    ListNode dummy = new ListNode(-1);
    dummy.next = head;                                                //因为需要操作第一个节点，所以使用虚拟头节点
    ListNode cur = dummy;
    ListNode first;
    ListNode second;
    ListNode temp = null;
    while(cur.next != null && cur.next.next != null){
        temp = cur.next.next.next;
        first = cur.next;
        second = cur.next.next;
        cur.next = second;
        second.next = first;
        first.next = temp;                                              //此时first已经变为需要交换的第二的索引位置
        cur = first;
    }
    return dummy.next;
    }
}
