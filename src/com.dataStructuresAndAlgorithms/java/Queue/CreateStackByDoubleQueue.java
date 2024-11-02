package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class CreateStackByDoubleQueue {
    //双单向队列实现栈
        //栈队列：这个队列中的元素与栈中的元素相同，顺序相反
        private Queue<Integer> first;

        //辅助队列
        private Queue<Integer> second;
        //初始化方法
        public CreateStackByDoubleQueue() {
            first  = new LinkedList<>();
            second = new LinkedList<>();
        }

    /*
    是否为空
    因为first是储存元素的队列，first中的元素即是栈中的元素，first为空则栈为空
    为空返回true，否则返回false
     */

        public boolean isEmpty() {
            return first.isEmpty();
        }


        /*
        入栈
       先用second辅助栈储存新元素，再将first中的元素全都存入second，此时second中的元素的顺序满足先进后出，将first与second交换，得到栈
         */
        public void push(int value) {
            //辅助队列存入元素
            second.offer(value);
            //将first中所有的元素全部存入second
            while (!first.isEmpty()){
                second.offer(first.poll());
            }
            //first与second交换，为下一次入栈做准备
            Queue<Integer> temp = first;
            first = second;
            second = temp;
        }

        /*
        得到栈顶元素，并移除
        因为first中的元素满足先入后出，直接将first.poll，就得到栈首元素
         */
        public int pop() {
            return first.poll();
        }

    /*
    得到栈首元素的值
    first满足先入后出，直接first.peek，即可得到栈首元素的值
     */

        public int peek(){
            return first.peek();
        }


        public static void main(String[] args) {
            CreateStackByDoubleQueue queue = new CreateStackByDoubleQueue();
            queue.push(2);
            queue.push(3);
            System.out.println(queue.isEmpty());
            System.out.println(queue.peek());
            System.out.println(queue.pop());
            System.out.println(queue.peek());
        }
    }
