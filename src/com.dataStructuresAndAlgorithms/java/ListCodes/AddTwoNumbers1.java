package ListCodes;

public class AddTwoNumbers1 {
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
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            //双指针指向首尾
            ListNode head = null, tail = null;
            //存储1进位
            int carry = 0;
            //计算两链表对应位置的和，因为表示的数字是逆序的，所以对应位相同
            while (l1 != null || l2 != null) {
                //巧妙判断l1不为空时
                int n1 = l1 != null ? l1.val : 0;
                int n2 = l2 != null ? l2.val : 0;
                //计算和=n1+n2+进位
                int sum = n1 + n2 + carry;
                //head为空，说明节点未添加，首尾直接初始化
                if (head == null) {
                    head = tail = new ListNode(sum % 10);
                } else {
                    //head不为空，移动tail表示链表尾部移动
                    tail.next = new ListNode(sum % 10);
                    tail = tail.next;
                }
                carry = sum / 10;
                if (l1 != null) {
                    l1 = l1.next;
                }
                if (l2 != null) {
                    l2 = l2.next;
                }
            }
            //最后进位判断
            if (carry > 0) {
                tail.next = new ListNode(carry);
            }
            return head;
        }
}
