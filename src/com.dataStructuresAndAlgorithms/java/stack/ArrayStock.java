package stack;

//顺序栈的实现

//  索引： 0    1     2    3   4
//  元素： a    b     c    d   e
//
public class ArrayStock <E>{

    //定义泛型组
private E[] array;

//构造方法

public ArrayStock(int capacity){
    //没办法直接new 泛型数组所以使用Object数组 + 类型强转
    array = (E[]) new Object[capacity];
}

//栈顶指针

private int top;


/*
判断是否为空
 */
public boolean isEmpty(){
    return top == 0;
}

/*
判断是否栈满
 */
    public boolean isFull(){
    return top == array.length;
    }

    /*
    压栈
    索引随top指针的增加而增大
    注意：这是先top，然后top再自增
     */
    public boolean push(E value){
    if(isFull()){
        return  false;
    }
    array[top] = value;
    top ++;
    return true;
    }


    /*
    出栈
    因为top的值与数组中元素的数量相等
     */


    public E pop(){
    if (isEmpty()){
        return  null;
    }
    E value = array[top-1];
    top--;
    return value;
    }


    /*
    查看栈顶元素
     */

    public E peek(){
        if (isEmpty()){
            return  null;
        }
        E value = array[top-1];
        return value;
    }

/*
打印数组元素
因为栈要满足先进后出，则要从后向前遍历
 */
    public void print(){
        for (int i = top-1; i >=0; i--) {
            System.out.println(array[i]);
        }
    }
    /*
    清空栈
     */
    public  void clear(){
        array = (E[]) new Object[top];
    }



    public static void main(String[] args) {
        ArrayStock stack = new ArrayStock(10);
        stack.push(3);
        stack.push("hello");
        stack.push('A');
        stack.push("B");
        System.out.println(stack.isEmpty());
        System.out.println("----------------------");
        stack.print();
        System.out.println("----------------------");
        System.out.println(stack.pop());
        System.out.println("----------------------");
        stack.print();
        stack.clear();
        stack.print();
    }
}
