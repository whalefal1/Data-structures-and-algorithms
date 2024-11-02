package Queue;
//链队列
public class LinkedQueue<E>{
    private static class Node<E>{
        E val;
        Node<E> next;

        public Node(E val) {
            this.val = val;
        }
    }


    Node<E> head = new Node<>(null);
    Node<E> tail = head;
    //元素数量
    private int size;
    //队列容量
    private int capacity = Integer.MAX_VALUE;

    public LinkedQueue(int capacity) {
        this.capacity = capacity;
    }

    /*
    向队列尾插入元素
    若插入成功则返回true，失败则返回false
     */
    public boolean offer(E value){
        if(isFull()){
            return false;
        }
        //初始化新节点，使其指向哨兵节点
        Node<E> added = new Node<>(value);
        //将新节点添加到队列的尾部
        tail.next = added;
        //尾节点指向新节点
        tail = added;
        size++;
        return true;
    }

    /*
     检查队列是否为空
     空则返回true，否则返回false
     */
    public boolean isEmpty(){
        //因为tail指针始终指向最后添加的元素，当队列为空时，head和tail都指向哨兵节点
        return  head == tail;
    }

    /*
    检查队列是否已满
    满返回true，否则返回false
     */
    public boolean isFull(){
        return size == capacity;
    }

    /*
    从队列头不获取队列值，不移除
    如果队列非空返回头值，否则返回null
     */
    public E peek(){
        if(isEmpty()){
            return null;
        }
        //head一直指向哨兵节点，哨兵节点的下一个节点就是队列的头
        return head.next.val;
    }


    /*
    从队列头获取值，并移除
    如果队列非空返回头值，否则返回null
     */
    public E poll(){
        if(isEmpty()){
            return null;
        }
        //head一直指向哨兵节点，哨兵节点的下一个节点就是队列的头部，所以队列头部就是head.next
        Node<E> first =  head.next;
        //删除队列的头部就相当于删除头节点，直接让哨兵节点指向第二个节点就行了
        head.next = first.next;
        //特殊情况处理：当队列中的元素全都删除时，此时需要将tail指针指向哨兵节点
        if(first == tail){
            tail = head;
        }
        size --;
        //返回头节点的值
        return first.val;
    }


    public static void main(String[] args) {
        LinkedQueue arrayQueue = new LinkedQueue(3);
        arrayQueue.offer(1);
        arrayQueue.offer(2);
        arrayQueue.offer(3);
        System.out.println(arrayQueue.isEmpty());
        System.out.println(arrayQueue.offer(4));
        System.out.println(arrayQueue.peek());
        arrayQueue.poll();
        System.out.println(arrayQueue.peek());
    }
}
