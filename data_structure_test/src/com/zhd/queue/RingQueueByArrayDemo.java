package com.zhd.queue;

import java.util.Scanner;

/**
 * 环形队列的实现： 能够让数组复用
 */
public class RingQueueByArrayDemo {

    public static void main(String[] args) throws Exception {
        //初始化一个容量为3的队列
        RingQueue arrayQueue = new RingQueue(3);

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
                        arrayQueue.remove();
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
                        arrayQueue.showHeader();
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

/**
 * 环形队列类
 */
class RingQueue {
    private int maxSize; // 定义队列的最大长度
    private int front; // 指向队列头部  初始值设定为0
    private int rear; // 只想队列的尾部  初始化设置为0
    private int[] array; //一个存储数组

    /**
     * 初始化队列长度的构造方法
     */
    public RingQueue(int length) {
        maxSize = length;
        array = new int[maxSize];
    }

    /**
     * 判断是否为空
     */
    boolean isEmpty() {
        return front == rear;
    }

    /**
     * 判断是否满了
     */
    boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    /**
     * 添加元素（入队）
     */
    void add(int data) {
        if (isFull()) {
            System.out.println("队列已经满了，不能添加添加");
            return;
        }
        //添加数据
        array[rear] = data;
        //rear 后移一位   因为考虑到是环形结构  因此用模
        rear = (rear + 1) % maxSize;
    }

    /**
     * 取出数据（出队）
     */
    int remove() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空,不能取出数据");
        }

        /**
         * 取出思路
         * 1.先定义一个局部变量 存储当前值（不然移动下标之后这个值会丢失）
         * 2.然后移动下表
         * 3.将变量值反汇
         */
        int i = array[front];
        array[front] = 0;
        front = (front + 1) % maxSize;
        return i;
    }

    /**
     * 展示数据
     */
    void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空，没有数据");
            return;
        }
        /**
         * 注意因为为环形队列   没办法得到长度
         * 队列起始位置为front
         */
        for (int i = front; i < size()+front; i++) {
            System.out.println(i);
            System.out.println(i%maxSize);
            System.out.printf("queue[%d]=%d\n", i%maxSize, array[i%maxSize]);
        }
        System.out.println();
    }

    /**
     * 查看头数据
     */
    void showHeader() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空,不能取出数据");
        }
        System.out.println("头数据为:" + array[front]);
    }

    /**
     * 查询队列的有效数据的数量
     */
    int size() {
        //rear = 3 队列 后部为3
        //front = 2 队列 前部为2
        //maxSize = 5 队列长度为5
        //有效数据的大小  （3+5-2）% 5
        return (rear + maxSize - front) % maxSize;
    }


}
