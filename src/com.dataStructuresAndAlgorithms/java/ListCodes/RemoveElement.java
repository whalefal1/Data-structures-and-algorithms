package ListCodes;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/*
删除链表中的节点
解法一：使用虚拟节点
 */
public class RemoveElement {
    public ListNode removeElements1(ListNode head, int val) {
        if (head == null) {                                                         //判断链表是否为空
            return head;
        }
        ListNode dummy = new ListNode(-1, head);           //声明虚拟头节点
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null) {                                                      //遍历链表,注意：是cur != null
            if (cur.val == val) {                                                   //判断头节点是否符合条件，若符合去除头节点，若不符合判断下一个
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return dummy.next;                                                     //注意返回的是dummy.next
    }

    /*不设置虚拟节点
    解法二：
     */
    public ListNode removeElements2(ListNode head, int val) {
        while (head != null && head.val == val) {                             //判断首节点的值是否为符合条件，若符合，移除收节点，并把下一个节点当作首节点，若不符合，结束循环
            head = head.next;
        }
        if (head == null) {
            return head;
        }
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null) {                                                                             //遍历链表
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;                                                                               //注意：先写遍历语句
        }
        return head;
    }

    /*
    解法三：不添加虚拟节点and pre Node方式
     */
    public ListNode removeElements3(ListNode head, int val) {
        while(head != null && head.val == val){
            head  = head.next;
        }
        ListNode cur = head;
        while(cur != null){
            while(cur.next != null && cur.next.val != val){                                 //双重遍历：第一层遍历每一个链表节点，第二层遍历的是当前节点的下一个节点，若符合条件则一直去除，若不符合则结束循环
                cur.next = cur.next.next;
            }
            cur = cur.next;
        }
        return  head;
    }
}