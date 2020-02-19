package com.zhd.queue;

import java.util.Scanner;

/**
 * 简单实现模拟队列
 * 先入先出 （用数组实现）
 * 实际运用 银行排号系统的运用
 *
 * 问题：目前数组使用一次就不能用，没有实现复用的效果
 * 可以使用算法，改进成一个环形队列
 */
public class ArrayQueueDemo {
    public static void main(String[] args) throws Exception {
        //初始化一个容量为3的队列
        ArrayQueue arrayQueue = new ArrayQueue(3);

        //
        boolean loop = true;
        while (loop) {
            System.out.println("a(data)添加数据");
            System.out.println("r(data)移除数据");
            System.out.println("s(data)展示所有数据");
            System.out.println("h(data)展示头数据数据");
            System.out.println("e(exit)结束程序");
            Scanner scanner = new Scanner(System.in);
            String next = scanner.next();
            switch (next) {
                case "a":
                    //添加数据
                    System.out.println("请输入要添加的数据");
                    int data = scanner.nextInt();
                    arrayQueue.add(data);
                    break;
                case "r":
                    //移除数据
                    try {
                        arrayQueue.removeQueue();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "s":
                    //展示所有数据
                    arrayQueue.showQueue();
                    break;
                case "h":
                    //展示头数据
                    try {
                        arrayQueue.headQueue();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "e":
                    //结束程序
                    scanner.close();
                    loop = false;
                    break;
                default:
                    //...;
                    break;
            }
        }
        System.out.println("程序结束");
    }
}

class ArrayQueue {

    //数组的最大容量
    private int maxSize;
    private int[] array;
    private int front;
    private int rear;

    public ArrayQueue(int i) {
        maxSize = i;
        array = new int[i];
        front = -1; //队列头，指向队列头的前一个位置
        rear = -1;  //队列尾，指向队列尾的尾部的数据（只想队列位置的最后一个数据）
    }

    /**
     * 判断队列是否满
     *
     * @param
     */
    boolean isFull() {
        return rear == maxSize -1;
    }

    /**
     * 判断队列是否为空
     *
     * @param
     */
    boolean isEmpty() {
        return rear == front;
    }

    /**
     * 添加数据
     *
     * @param i
     */
    void add(int i) {
        if (isFull()) {
            System.out.println("数组已满，不能添加");
            return;
        }
//        rear++;
        array[++rear] = i;
    }

    /**
     * 取出数据
     */
    int removeQueue() {
        if (isEmpty()) {
            throw new RuntimeException("数组为空，不能取出数据");
        }
        //因为fount是 队列头部的前一个位置
        front++;
        System.out.println("已移除："+array[front]);
        //清空当前a数据
        array[front] = 0;
        return array[front];
    }

    /**
     * 遍历数据
     */
    void showQueue() {
        if (isEmpty()) {
            System.out.println("数组为空，没有数据");
            return;
        }
        for (int i = 0; i < array.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, array[i]);
        }
    }

    /**
     * 显示头数据
     */
    void headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("数组为空，没有此数据");
        }
        System.out.println("头数据为:"+array[front + 1]);
    }
}
