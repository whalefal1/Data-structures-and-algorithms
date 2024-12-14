package Stack;

//链栈的实现
public class LinkedStock <E>{
    //节点类
    static class Node<E>{
        E value;
        Node<E> next;

        public Node(E value, Node<E> next) {
            this.value = value;
            this.next = next;
        }
    }

    //定义容量
    private  int capacity;


    //元素数量
    private  int size;


    //头节点（头节点指向栈顶元素，但没有进入栈）

    private Node<E> head = new Node(-1,null);
   //构造方法
    public LinkedStock(int capacity) {
        this.capacity = capacity;
    }

    //判断是否为空

    public boolean isEmpty(){
        return  head.next == null;
        //return size = 0;
    }


    //判断是否栈满

    public  boolean isFull(){
        return  size == capacity;
    }


    //添加元素


    public boolean push(E value){
        if(isFull()){
            return  false;
        }
         head.next = new Node<>(value,head.next);
         size++;
         return true;
    }


    //移除栈顶元素

    public E pop(){
        if (isEmpty()){
            return null;
        }
        Node<E> first = head.next;
        head.next = first.next;
        size--;
        return first.value;
    }

    //栈顶元素的值

    public  E peek(){
        if (isEmpty()){
            return  null;
        }
        return head.next.value;
    }

//打印栈内元素
    public void print(){
        Node<E> top = head.next;
        while(top != null){
            System.out.println(top.value);
           top = top.next;
        }
    }

    //清空栈
    public void clear(){
        size = 0;
    }


    public static void main(String[] args) {
        LinkedStock stack = new LinkedStock(10);
        stack.push(3);
        stack.push("hello");
        stack.push('A');
        stack.push("B");
        System.out.println(stack.isEmpty());
        stack.isFull();
        stack.peek();
        stack.print();
        stack.pop();
        stack.print();
    }
}
