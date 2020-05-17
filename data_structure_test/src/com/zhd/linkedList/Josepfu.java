package com.zhd.linkedList;

/**
 * 循环链表实现约瑟夫问题
 */
public class Josepfu {

    public static void main(String[] args) {
        SingleCircleLinkedList singleCircleLinkedList = new SingleCircleLinkedList();
        Boy linked = singleCircleLinkedList.createLinked(5);
        singleCircleLinkedList.show(linked);

        singleCircleLinkedList.countBoy(1,2,5);
    }
}

class SingleCircleLinkedList {
    private Boy head = null;

    /**
     * 创建 数量为5的循环链表
     */
    public Boy createLinked(int nums) {
        if (nums < 1) {
            System.out.println("请创建大于一的循环链表");
            return null;
        }
        Boy cur = null;
        for (int j = 1; j <= nums; j++) {
            Boy boy = new Boy(j);
            if (j == 1) {
                head = boy;
                head.setNext(head);
                cur = head;
            } else {
                assert false;
                cur.setNext(boy);
                boy.setNext(head);
                cur = boy;
            }
        }
        return head;
    }

    /**
     * 便利链表
     *
     * @param node
     */
    public void show(Boy node) {
        Boy cur = node;
        while (true) {
            System.out.printf("第%d个孩子的编号为%d \n", cur.getNo(), cur.getNo());
            if (cur.getNext() == head) {
                break;
            }
            cur = cur.getNext();
        }
    }

    /**
     * 根据用户需求,计算小孩出圈顺序
     *
     * @param startNo 从第几个小孩开始数
     * @param countNo 表示数几下
     * @param boys    小孩的个数
     */
    void countBoy(int startNo, int countNo, int boys) {
        if (startNo < 1 || countNo > boys || head == null) {
            System.out.println("nononon");
            return;
        }
        //首先先定义一个辅助节点helper
        Boy helper = head;
        //将hepler节点置与头结点的前一个结点
        while (helper.getNext() != head) {
            helper = helper.getNext();
        }
        //根据startNo 找到想要从当前开始数的那个小孩的位置
        for (int i = 0; i < startNo - 1; i++) {
            head = head.getNext();
            helper = helper.getNext();
        }
        //将数到的小孩取出  
        while (true) {
            if (helper == head) {
                break;
            }
            for (int i = 0; i < countNo - 1; i++) {
                head = head.getNext();
                helper = helper.getNext();
            }
            System.out.printf("小孩%d出拳", head.getNo());
            head = head.getNext();
            helper.setNext(head);
        }
        System.out.printf("最后一个出圈的小孩编号为%d", helper.getNo());
    }
}

class Boy {
    private int no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
