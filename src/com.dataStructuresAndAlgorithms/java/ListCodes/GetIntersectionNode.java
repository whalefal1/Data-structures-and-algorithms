package ListCodes;
/*
链表相交
 */
public class GetIntersectionNode {
    public ListNode solution(ListNode headA, ListNode headB){
        ListNode curA = headA;
        ListNode curB = headB;
        int lenA = 0,lenB = 0;
        while(curA!=null){                         //遍历链表A，得到链表A的长度
            lenA++;
            curA = curA.next;
        }
        while(curB!= null){                         //遍历链表B，得到链表B的长度
            lenB++;
            curB = curB.next;
        }
        curA = headA;                               //指针AB返回头节点
        curB = headB;
        if(lenB>lenA){                               //比较链表AB的长度，使A为长链表
            int temp = lenB;
            lenB = lenA;
            lenA = temp;
            ListNode tem = curB;
            curB = curA;
            curA = tem;
        }
        int gap = lenA - lenB;
        while(gap > 0){                            //使指针AB处于两个链表上的同一位置（相对于交点）
            gap--;
            curA = curA.next;
        }
        while(curA!=null){
            if(curB == curA){                  //继续遍历，知道找到两链表相同的节点
                return curA;
            }
            curB = curB.next;
            curA = curA.next;
        }
        return null;
    }
}
