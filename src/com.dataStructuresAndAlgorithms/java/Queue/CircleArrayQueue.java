package Queue;

import java.util.Iterator;
//循环数组队列
public class CircleArrayQueue<E> {
    private E[] array;
    public int head = 0;
    private int tail = head;

    public CircleArrayQueue(int capacity) {
        //数组容量加1的原因：数组的最后一个索引不能存放数据，要专门留给尾指针，以便判断是否存满
        array = (E[]) new Object[capacity+1];
    }

    /*
        判断是否为空
        空则返回true，否则返回false
     */
    public boolean isEmpty(){
        //head一直指向数组中的第一个元素，而tail指向数组的随后一个元素，随数组中元素的增加而增加，当head==tail时说明数组中没有添加元素
        return head == tail;
    }
    /*
    判断是否已满
    满则返回true，否则返回false
     */
    public boolean isFull(){
        //若队列已满，则tail指针在数组中指向数组最后一个元素，因为数组为环形数组，所以当tail后移一位就与head指向相同
        return ( tail + 1 ) % array.length == head;
    }

    /*
    新增元素
    成功返回true，失败返回false
     */

    public boolean offer(E value){
        if (isFull()){
            return  false;
        }
        array[tail] = value;
        tail = (tail + 1) % array.length;
        return true;
    }

    /*
    从队列头部移除元素
    成功返回队列头部元素元素，否则还会返回null
     */
    public E poll(){
         if (isEmpty()){
             return null;
         }
         //head指针一直指向数组的首元素，直接取
         E value = array[head];
         //取出之后，head指针需要后移一位，此时head指针指向数组的第二个元素
         head = (head + 1) % array.length;
         return value;
    }

    /*
    获取队列的首元素的值但不移除
    成功返回元素值，失败返回null
     */
    public E peek(){
        if (isEmpty()){
            return null;
        }
        E value= array[head];
        return value;
    }

    /*
    迭代器
     */
    public Iterator<E> iterator(){
        return new Iterator<E>() {
            int p = head;
            @Override
            public boolean hasNext() {
                return  p != tail;
            }

            @Override
            public E next() {
                E value = array[p];
                p = (p + 1) % array.length;
                return value;
            }
        };
    }

    public static void main(String[] args) {
        CircleArrayQueue<Integer> queue = new CircleArrayQueue<>(3);
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        System.out.println(queue.peek());
        System.out.println(queue.offer(4));
        Integer poll = queue.poll();
        System.out.println(poll);
        System.out.println(queue.peek());
    }
}
