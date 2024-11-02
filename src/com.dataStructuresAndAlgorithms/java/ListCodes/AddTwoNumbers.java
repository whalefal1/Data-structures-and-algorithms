package ListCodes;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(1);
        while (l2 != null && l1 != null) {
            int sum = l1.val + l2.val;
            ListNode res1 = new ListNode(sum,res);
           res = res1;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1!=null){
            ListNode res1 = new ListNode(l1.val,res);
            res = res1;
            l1 = l1.next;
        }
        while(l2!=null){
            ListNode res2 = new ListNode(l2.val,res);
            res = res2;
            l2 = l2.next;
        }
        ListNode pre = null;
        ListNode cur = res;
        ListNode temp = null;
        while(cur!=null){
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
       ListNode result = new ListNode(0, pre);
        while(result!=null){
            if(result.val>9){
                result.next.val+=1;
               result.val-=10;
            }
            result = result.next;
        }
        return pre.next;
    }
/*
8   9    9    5                        1     9      1
           l1                                            l2
5     10   18   9
 */
    public static void main(String[] args) {
        ListNode m = new ListNode(5,null);
        ListNode a = new ListNode(9, m);
        ListNode b = new ListNode(9, a);
        ListNode c = new ListNode(8, b);
        ListNode d = new ListNode(1, null);
        ListNode e = new ListNode(9, d);
        ListNode f = new ListNode(1, e);
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        System.out.println(addTwoNumbers.addTwoNumbers(c, f).next.next.next.val);
    }
}
