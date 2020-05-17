package com.zhd.stark;

import java.util.Scanner;

/**
 * 数组实现队列
 *
 * 思路
 * 1.
 */
public class ArrayStackDemo {

    public static void main(String[] args) {

        ArrayStack arrayStack = new ArrayStack(4);
        System.out.println("程序开始");
        String key = "";
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;

        while (loop){
            System.out.println("show:展示栈");
            System.out.println("exit:退出程序");
            System.out.println("push:入栈");
            System.out.println("pop:出栈");
            System.out.println("请输入你的选择");
            key = scanner.next();
            switch (key){
                case "show":
                    arrayStack.show();
                    break;
                case "exit":
                    loop = false;
                    break;
                case "push":
                    System.out.println("请输入一个数：");
                    int i = scanner.nextInt();
                    arrayStack.push(i);
                    break;
                case "pop":
                    try {
                        int pop = arrayStack.pop();
                        System.out.println(pop);
                    }catch (RuntimeException e){
                        System.out.println(e);
                    }
                    break;
            }
        }
    }

}
class ArrayStack{
    private int maxSize; //栈的容量
    private int[] array; //存储数据的数组
    private int top;     //出栈的指针

    public ArrayStack(int maxSize){
        this.maxSize = maxSize;
        array = new int[maxSize];
        top = -1;
    }

    /**
     * 判断栈空
     */
    public boolean empty(){
        return top == -1;
    }
    /**
     * 判断栈满
     */
    public boolean isFull(){
        return top == maxSize-1;
    }

    /**
     * 入栈
     */
    public void push(int val){
        if(isFull()){
            System.out.println("队列已经满了");
        }
        top++;
        array[top] = val;
    }
    /**
     * 出栈
     */
    public int pop(){
        if (empty()){
            throw new RuntimeException("队列为空，不能出栈");
        }
        int val = array[top];
        top--;
        return val;
    }
    /**
     * 展示
     */
    public void show(){
        if(empty()){
            System.out.println("队列为空");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("第【%d】个，值为【%d】\n",i , array[i]);
        }
    }
}

