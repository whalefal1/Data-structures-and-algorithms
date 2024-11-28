package ListCodes;


import java.util.LinkedList;
import java.util.Queue;

public class Partition {

    public static ListNode partition(ListNode head, int x) {
        if (x == 0) return null;
        Queue<ListNode>  queue = new LinkedList<>();
        ListNode right = new ListNode(-1,head);
        ListNode left = new ListNode(-1,null);
        while(head!=null){
            if(head.val < x){
                if(left.next == null){
                    left.next = head;
                }
                right.next = head;
                right = right.next;
            }else{
                queue.add(head);
            }
            head = head.next;
        }

        while(!queue.isEmpty()){
            ListNode poll = queue.poll();
            if(left.next == null){
                left.next = poll;
            }
            right.next = poll;
            right = right.next;
        }
        right.next = null;
        return left.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(2);
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        partition(n1,0);

    }
}
