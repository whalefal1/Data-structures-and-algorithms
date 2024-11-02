package Queue;
//顺序队列
public class ArrayQueue<E> {
    //声明数组
    private  E[] array;
    //声明容量
    private int capacity;
    //声明头指针
    private int head;
    //声明尾指针
    private int tail;
//初始化方法
    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        array = (E[]) new Object[capacity];
    }
    //判断是否为空
    public boolean isEmpty(){
        return  head == tail;
    }
//判断是否已满
    public boolean isFull(){
        return tail == capacity;
    }
//插入元素
    public boolean offer(E value){
        if (isFull()){
            return  false;
        }
        //若为空则头尾指针都指向第一个元素
        if(isEmpty()){
            head = 0;
            tail = 1;
            array[head] = value;
        }else {
            //若不为空，头指针已经指向第一个元素，尾指针指向后移
            array[tail] = value;
            tail++;
        }
        return true;
    }
    //获得第一个元素并移除
    public E poll(){
        if (isEmpty()){
            return null;
        }
        E value = array[head];
        head++;
        return value;
    }
    //获得第一个元素
    public E peek(){
        if (isEmpty()){
            return null;
        }
        E value= array[head];
        return value;
    }

    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
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
