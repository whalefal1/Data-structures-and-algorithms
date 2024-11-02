package Queue;

import java.util.LinkedList;
import java.util.Queue;
//单队列实现栈
public class CreateStackByOneQueue {
    private Queue<Integer> queue;

    public CreateStackByOneQueue() {
        queue = new LinkedList<>();
    }

    /*
    入栈，直接将新元素入队，通过queue.size()获取队列的元素数量，将队列遍历size-1次，将原来的元素先出队再添加到队列中，从而实现队列先入后出的顺序
     */
    public  void push(int value){
        queue.offer(value);
        for (int i = 0 ; i < queue.size() ; i ++ ){
            queue.offer(queue.poll());
        }
    }
    public int peek(){
        return queue.peek();
    }
    public int pop(){
        return queue.poll();
    }
    public boolean isEmpty(){
        return queue.isEmpty();
    }
    public static void main(String[] args) {
        CreateStackByOneQueue queue = new CreateStackByOneQueue();
        queue.push(2);
        queue.push(3);
        System.out.println(queue.isEmpty());
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.peek());
    }
}
