package Queue;
import java.util.Stack;
//用栈实现队列
public class CreateQueueByStack {
    //队列栈用于储存元素，其元素数量与栈元素数量一致，且顺序满足先入后出
    Stack<Integer> first;
    //辅助队列
    Stack<Integer> second;
    public CreateQueueByStack() {
        first = new Stack<>();
        second = new Stack<>();
    }

    /*
    first
    ---------------------------
    |3   2   1
    ---------------------------

    second
    ---------------------------
    |null
    ---------------------------
     */

/*
入栈
先将first中的元素都储存到second中，再将新元素添加到second中，此时second中的元素顺序满足后人先出，再将second中的元素存入first中，此时元素满足先入先出
 */
    public void offer(int value){
            while(!first.isEmpty()){
            second.push(first.pop());
        }
        second.push(value);
        while(!second.isEmpty()){
            first.push(second.pop());
        }
    }
/*
获得队列首元素并移除
first栈满足先入先出原则，first.pop()获得的栈顶元素就是队列的首元素
 */
    public int poll(){
        return first.pop();
    }
/*
获得队列元素，但不移除
first栈满足先入先出原则，first.pop()获得的栈顶元素就是队列的首元素
 */
    public int peek(){
        return first.peek();
    }
    /*
    判断是否为空队列
    first栈中的元素数量就是队列中的元素数量，若first为空，则栈为空
     */
    public boolean isEmpty(){
        return first.isEmpty();
    }

    public static void main(String[] args) {
        CreateQueueByStack stack = new CreateQueueByStack();
        System.out.println(stack.isEmpty());
        stack.offer(1);
        stack.offer(2);
        stack.offer(3);
        System.out.println(stack.isEmpty());
        System.out.println(stack.peek());
        System.out.println(stack.poll());
        System.out.println(stack.peek());
    }
}
