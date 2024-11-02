package ListCodes;
/*
设计链表
 */
public class MyLinkedList {
    int size;
    ListNode head;

    public MyLinkedList(int size) {
        this.size = size;                              //初始化链表
        head = new ListNode(0);
    }

    public MyLinkedList() {
        size = 0;
        head = new ListNode(0);         //初始化链表
    }

    public  int get(int index){                  //获取第index个节点的数值，注意index是从0开始的，第0个节点就是头结点，最后一个节点的index是size-1
        if (index < 0 || index >= size) {      //判断是否非法
            return -1;
        }
       ListNode currentNode = head;
        for (int i = 0; i <= index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode.val;
    }

    public void delete(int index) {           //删除第index个节点
        if (index < 0 || index >= size) {
            return;
        }
        size--;
        if (index == 0) {
            head = head.next;
            return;
        }
        ListNode pred = head;
        for (int i = 0; i < index ; i++) {      //找到index的前一个节点
            pred = pred.next;
        }
        pred.next = pred.next.next;
    }
    public void update(int index,int val){       //修改第index个节点的值
        if (index < 0 || index >= size) {
            return;
        }
        ListNode cur = head;
        for (int i = 0; i <= index; i++) {
            cur = cur.next;
        }
        cur.val = val;
    }
    public void add(int index, int val) {
        if (index > size) {
            return;
        }
        if (index < 0) {
            index = 0;
        }
        size++;
        //找到要插入节点的前驱
        ListNode pred = head;
        for (int i = 0; i < index; i++) {
            pred = pred.next;
        }
        ListNode toAdd = new ListNode(val);
        toAdd.next = pred.next;
        pred.next = toAdd;
    }
}
