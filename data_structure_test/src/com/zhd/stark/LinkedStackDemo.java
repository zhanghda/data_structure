package com.zhd.stark;

import java.util.Scanner;

/**
 * 思路：
 * <p>
 * 因为栈是后进先出
 * 因此使用链表实现： 最好使用头插法，
 * 入栈的时候，将新插入的作为头结点
 * 出站的时候，将第一个指针后移，第二个变成头节点
 */

public class LinkedStackDemo {


    public static void main(String[] args) {
        LinkedStack linkedStack = new LinkedStack();
        System.out.println("程序开始");
        String key = "";
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;

        while (loop){
            System.out.println("show:展示栈");
            System.out.println("exit:退出程序");
            System.out.println("push:入栈");
            System.out.println("pop:出栈");
            System.out.println("length:长度");
            System.out.println("top:栈顶");
            System.out.println("请输入你的选择");
            key = scanner.next();
            switch (key){
                case "show":
                    linkedStack.show();
                    break;
                case "exit":
                    loop = false;
                    break;
                case "push":
                    System.out.println("请输入一个数：");
                    String i = scanner.next();
                    linkedStack.push(i);
                    break;
                case "pop":
                    try {
                        linkedStack.pop();
                    }catch (RuntimeException e){
                        System.out.println(e);
                    }
                    break;
                case "length":
                    int length = linkedStack.length();
                    System.out.println(length);
                    break;
                case "top":
                    String a = (String) linkedStack.top();
                    System.out.println(a);
                    break;
            }
        }
    }
}

class LinkedStack {

    Node headNode = null; //存放数据的链表


    /**
     * 判断对空
     */
    public boolean empty() {
        return headNode == null;
    }

    /**
     * 入栈
     * 可分为三种情况：
     * 1.只有头节点但是值为空
     * 2.无头结点
     * 3.有多个节点
     */
    public void push(String val) {
        if (headNode == null) {
            headNode = new Node(val);
        } else if (headNode.getData() == null) {
            headNode.setData(val);
        } else {
            Node node = new Node(val);
            node.next = headNode;
            headNode = node;
        }
    }

    /**
     * 出栈:分析
     * 1.如果是一个空栈（即头结点是空的） return
     * 2.如果不是 直接压出数据
     */
    public void pop() {
        if (empty()) {
            System.out.println("站是空的");
            return;
        }
        headNode = headNode.next;
    }

    /**
     * 返回栈顶的值
     */
    public Object top() {
        if (empty()) {
            throw new RuntimeException("栈为空");
        }
        return headNode.getData();
    }

    /**
     * 展示栈
     */
    public void show() {
        if (empty()) {
            System.out.println("站是空的");
            return;
        }
        Node temp = headNode;
        while (temp != null) {
            System.out.println("栈的值" + temp.getData());
            temp = temp.next;
        }
    }

    /**
     * 当前栈的length
     */
    public int length() {
        int i = 0;
        if (empty()) {
            return i;
        } else {
            Node temp = headNode;
            while (temp != null) {
                i++;
                temp = temp.next;
            }
            return i;
        }
    }

}

class Node {
    Object data;
    Node next;

    public Node(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
