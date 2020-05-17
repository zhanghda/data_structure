package com.zhd.linkedList;

import java.util.List;

public class DoubleLinkdeListDemo {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1, "张三");
        ListNode node2 = new ListNode(2, "里斯");
        ListNode node3 = new ListNode(3, "王五");
        ListNode node4 = new ListNode(4, "赵六");

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(node2);
        doubleLinkedList.add(node4);
        doubleLinkedList.add(node3);
        doubleLinkedList.add(node1);

        System.out.println("新增");
        doubleLinkedList.show();

        ListNode sr = new ListNode(2, "苏芮");
        ListNode update = doubleLinkedList.update(sr);

        System.out.println("修改之后");
        doubleLinkedList.show();

        doubleLinkedList.delete(2);
        System.out.println("删除之后");
        doubleLinkedList.show();

        System.out.println("排序添加");
        doubleLinkedList.addByOrder(node2);
        doubleLinkedList.addByOrder(node4);
        doubleLinkedList.addByOrder(node3);
        doubleLinkedList.addByOrder(node1);
        doubleLinkedList.show();

    }

}

class DoubleLinkedList{
    ListNode head = new ListNode(0,"");

    public ListNode getHead(){
        return head;
    }
    /**
     * 无序的增加方法
     */
    public ListNode add(ListNode node){
        ListNode temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = node;
        node.pre = temp;
        return temp.next;
    }
    /**
     * 顺序添加
     */
    public void addByOrder(ListNode node){
        ListNode temp = head.next;
        boolean flag = false;
        while (temp != null){
            if(temp.no > node.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            temp.pre.next = node;
            node.next = temp;
            node.pre.next = temp.pre;
            temp.next = node;
        }
    }
    /**
     * 打印方法
     */
    public void show(){
        ListNode temp = head;
        if(temp.next == null){
            return;
        }
        while (temp.next != null){
            System.out.println(temp.next);
            temp = temp.next;
        }
    }
    /**
     * 修改
     */
    public ListNode update(ListNode node){
        ListNode temp = head;
        boolean flag = false;
        while (temp.next != null){
            if(temp.next.no == node.no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            temp.next.name = node.name;
        }else {
            System.out.println("没有找到这个节点");
        }
        return head.next;
    }
    /**
     * 删除某个节点
     */
    public void delete(int no){
        ListNode cur = head.next;
        boolean flag = false;
        if(cur == null){
            System.out.println("链表为空");
            return;
        }
        while(cur != null){
            if(cur.no == no){
                flag =true;
                break;
            }
            cur = cur.next;
        }
        if(flag){
            cur.pre.next = cur.next;
            cur.next.pre = cur.pre;
        }
    }
}

class ListNode{
    int no;
    String name;
    ListNode next; //后指针
    ListNode pre;  //前指针

    public ListNode(int no,String name){
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}
