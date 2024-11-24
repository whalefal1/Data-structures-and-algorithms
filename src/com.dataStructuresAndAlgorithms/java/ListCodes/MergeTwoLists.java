package ListCodes;

public class MergeTwoLists {
    //合并有序链表 —— 递归方法，因为可能会多次操作一号链或者二号链上的节点，这个我们是不确定的
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
           if(list1 == null){
               //一号链节点已经遍历完毕，直接添加二号链节点
               return list2;
           } else if (list2 == null) {
               //二号链节点已经遍历完毕，直接添加一号链节点
               return list1;
           }else{
               if(list1.val<=list2.val){
                   //一号链节点小于二号链节点时，添加的是一号链节点，此时操作list1
                   list1.next = mergeTwoLists(list1.next,list2);
                   return list1;
               }else {
                   //二号链节点小于一号链节点时，添加的是二号链节点，此时操作list2
                   list2.next = mergeTwoLists(list1,list2.next);
                   return list2;
               }
           }
    }
}
