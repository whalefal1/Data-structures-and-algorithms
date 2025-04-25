package ListCodes;

import java.util.HashMap;

public class DeleteMiddle {

    public class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

    public ListNode deleteMiddle(ListNode head) {
        if(head == null) return null;
        ListNode first = head;
        ListNode last = head;
        while (last.next!=null && last.next.next != null){
            first = first.next;
            last = last.next.next;
        }
        first = first.next;
        return head;
    }
}
