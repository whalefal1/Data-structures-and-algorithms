package ListCodes;

import java.util.List;
import java.util.Set;

/*
翻转链表
 */
public class ReverseList {
    public ListNode solution(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        ListNode temp = null;              //定义空节点，用于储存cur.next
        while(cur != null){
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }



    public static void main(String[] args) {
        ListNode c = new ListNode(2,null);
        ListNode b = new ListNode(1,c);
        ListNode a = new ListNode(0,b);
        ReverseList reverseList = new ReverseList();
        ListNode p = reverseList.solution(a);
        ListNode head = new ListNode(0,p);
        while(head!=null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
