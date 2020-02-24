package com.zhd.linkedList;

import javax.xml.soap.Node;
import java.util.Stack;

/**
 *
 */
public class SingleLinkedListDemo {

    public static void main(String[] args) {

        NodeList node1 = new NodeList(1, "松江", "");
        NodeList node2 = new NodeList(8, "松江2", "");
        NodeList node3 = new NodeList(10, "松江3", "");
        NodeList node4 = new NodeList(29, "松江4", "");

        SinpleLinkedList sinpleLinkedList = new SinpleLinkedList();
//        sinpleLinkedList.add(node3);
//        sinpleLinkedList.add(node2);
//        sinpleLinkedList.add(node4);
//        sinpleLinkedList.add(node1);

//        sinpleLinkedList.show();

        sinpleLinkedList.addByOrder(node1);
        sinpleLinkedList.addByOrder(node3);
        sinpleLinkedList.addByOrder(node2);
        sinpleLinkedList.addByOrder(node4);

        sinpleLinkedList.show();
//        反转
//        sinpleLinkedList.rescive(sinpleLinkedList.getHead());
        System.out.println();

        sinpleLinkedList.show();

        System.out.println("反转打印");
        sinpleLinkedList.resvisePrint(sinpleLinkedList.getHead());
        //修改

        sinpleLinkedList.update(new NodeList(1, "1", "1"));

        System.out.println();
        sinpleLinkedList.show();
        System.out.println();

        //删除链表节点
        sinpleLinkedList.delete(1);
//        sinpleLinkedList.delete(4);
//        sinpleLinkedList.delete(2);
//        sinpleLinkedList.delete(3);

        //打印有效节点个数
        System.out.println(sinpleLinkedList.getLength(sinpleLinkedList.getHead()));

        //找出倒数第k个节点
        System.out.println(sinpleLinkedList.getNodeList(sinpleLinkedList.getHead(), 2));

        //测试两个链表加入后排序
        System.out.println("测试两个链表加入后排序");
        NodeList node7 = new NodeList(7, "7", "7");
        NodeList node9 = new NodeList(9, "9", "9");
        NodeList node11 = new NodeList(11, "11", "11");

        SinpleLinkedList sinpleLinkedList1 = new SinpleLinkedList();
        sinpleLinkedList1.addByOrder(node7);
        sinpleLinkedList1.addByOrder(node9);
        sinpleLinkedList1.addByOrder(node11);

        sinpleLinkedList1.show();
        NodeList nodeList = sinpleLinkedList.mergeNodeList(sinpleLinkedList.getHead(), sinpleLinkedList1.getHead());

        System.out.println("打印结果");
        while (nodeList.next != null) {
            System.out.println(nodeList.next);
            nodeList = nodeList.next;
        }
    }
}

/**
 * 定义一个类来管理链表
 */
class SinpleLinkedList {
    //先创建一个头结点 ，头节点不要动  不存放具体的数据
    private NodeList head = new NodeList(0, "", "");

    public NodeList getHead() {
        return head;
    }

    public void setHead(NodeList head) {
        this.head = head;
    }

    /**
     * 添加方法
     * 思路：不考虑排序
     * 具体操作：
     * 1.找到这个链表的最后一个节点
     * 2.然后往这个节点后面添加  要添加的节点
     */
    void add(NodeList nodeList) {
        //先定义一个临时节点，  temp变量指向头结点
        NodeList temp = head;
        //先找到尾节点的位置
        while (temp.next != null) {
            //每次循环向后找一位
            temp = temp.next;
        }
        //增加新节点到最后一个
        temp.next = nodeList;
    }

    /**
     * 按顺序增加 按no升序
     * 如果no重复，则添加失败给出提示
     * 思路：
     * 1.首先找到比自己id大的节点（temp.next.no > 新节点.no）
     * 2.插入
     */
    void addByOrder(NodeList nodeList) {
        //定义一个临时节点temp 指向头指针  ，用于帮助找到添加节点的位置
        //我们要找到插入位置的前一个结点，否则加入不了  因为单向链表不能往头的方向找
        NodeList temp = head;
        //定义一个flag 用于表示是否有重复 的节点
        boolean flag = false;
        while (true) {
            if (temp.next == null) { //该链表已经位于链表最后
                break;
            }
            if (temp.next.no == nodeList.no) {  //编号存在
                flag = true;
                break;
            }
            if (temp.next.no > nodeList.no) { //说明位置找到
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.println("编号重复了");
        } else {
            nodeList.next = temp.next;
            temp.next = nodeList;
        }
    }

    /**
     * 修改链表 根据id修改链表
     */
    void update(NodeList nodeList) {
        NodeList temp = head; //定义临时指针
        boolean flag = false; //如果找到id相同的节点  flag为true

        while (true) {
            if (temp.next == null) {  //表示元素已到达最后一个的节点 跳出循环
                break;
            }
            if (temp.next.no == nodeList.no) { //说明已经找到该节点
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next.name = nodeList.name;
            temp.next.nickName = nodeList.nickName;
        } else {
            System.out.println("并没有与之匹配的元素");
        }
    }

    /**
     * 删除
     * <p>
     * 注意：我们要找到待删除结点的前一个结点   如果找到的是待删除节点  找不到它的上一个节点，导致链表连不上
     * <p>
     * 被删除的节点将不会有其他引用指向，将直接会被垃圾回收机制回收
     */
    void delete(int no) {
        NodeList temp = head;
        boolean flag = false;  //找到要删除的节点时 为false
//        if(temp.next == null){  //链表为空
//            System.out.println("链表为空");
//            return;
//        }
        while (true) {
            if (temp.next == null) { //已经到达链表的尾部
                break;
            }
            if (temp.next.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.println("链表不存在");
        }

    }

    /**
     * 展示链表
     */
    void show() {
        if (head.next == null) {
            System.out.println("链表为空");
        }
        NodeList temp = head;
        while (temp.next != null) {
            System.out.println(temp.next);
            temp = temp.next;
        }
    }

    /**
     * 求链表的有效节点个数
     */
    int getLength(NodeList nodeList) {
        if (nodeList.next == null) {  //链表为空
            throw new RuntimeException("链表为空");
        }
        NodeList temp = nodeList;  //创建临时指针
        int count = 0;  //定义存放计数器
        while (true) {
            if (temp.next == null) {
                break;
            }
            count++;
            temp = temp.next;
        }
        return count;
    }

    /**
     * 求单链表中倒数第k个节点
     * <p>
     * 思路：
     * 因为是单链表   所以不能逆向寻找，只能正向
     * 1.求出该链表的长度 count
     * 2.正向寻找第n个节点  n= count - k
     */
    NodeList getNodeList(NodeList nodeList, int k) {
        if (nodeList.next == null) {  //链表为空
            throw new RuntimeException("链表为空");
        }
        //先定义一个临时指针
        NodeList temp = nodeList;
        int count = 0;// 定义一个计数器
        while (true) {  //求出链表长度
            if (temp.next == null) {
                break;
            }
            count++;
            temp = temp.next;
        }
        //开始寻找
        NodeList temp2 = nodeList.next;

        if (count < k) {
            throw new RuntimeException("链表长度不够");
        }
        int n = count - k;  //定义一个记录正向区数的位置  n ;
        int count2 = 0;
        boolean flag = false;
        while (true) {
            if (temp2.next == null) {
                break;
            }
            if (n == count2) {
                flag = true;
                break;
            }
            count2++;
            temp2 = temp2.next;
        }

        if (!flag) {
            System.out.println("查无此点");
        }
        return temp2;
    }

    /**
     * 单链表的反转
     * 思路：
     * 1.先创建一个临时头结点
     * 2.将目标节点依此从头取出   放到临时头结点 的最前端  （注意  取出当前节点之前  要把下一个节点存起来）
     * 3.再将原头节点指向临时节点后面的节点
     */
    void rescive(NodeList head) {
        //如果链表只有没有节点 或者只有一个节点  跳出
        if (head.next == null || head.next.next == null) {
            return;
        }
        NodeList cur = head.next; //定义一个辅助变量（指针）
        NodeList next = null;  //cur 的下一个变量
        NodeList nodeList = new NodeList(0, "", "");  //创建一个新的头结点
        //开始循环
        while (cur != null) {
            next = cur.next;  //先找到下一个节点
            cur.next = nodeList.next;  //把取下的节点 指向 新节点.next
            nodeList.next = cur;  //新节点  的下一个节点  指cur  构成一个链表
            cur = next; //指针指向下一个
        }
        head.next = nodeList.next;  //将新头结点换成 原来的头节点  完成
    }

    /**
     * 逆序打印单链表
     * 方式一  ：先逆序  在打印  （这样做的问题是 会改变链表结构）
     * 方式二 ：可以用栈这个数据结构 可以将各个节点压入栈中  ，利用栈先进后出的特点就实现了先进后出打印的问题
     * <p>
     * 目前使用方式而的形式
     */
    void resvisePrint(NodeList head) {
        if (head.next == null) {
            return;
        }
        NodeList temp = head;
        Stack<Object> stack = new Stack<>();
        while (temp.next != null) {
            stack.push(temp.next);
            temp = temp.next;
        }
        while (!stack.empty()) {
            System.out.println(stack.pop());
        }
    }

    /**
     * 合并两个有序链表，合并之后的链表依然有序
     */

    NodeList mergeNodeList(NodeList nodeList1, NodeList nodeList2) {
        //首先创建一个新链表用于存储
        NodeList result = new NodeList(0, "", "");
        NodeList resultTemp = result;
        NodeList cur1 = nodeList1.next;
        NodeList cur2 = nodeList2.next;
        while (cur1 != null && cur2 != null){
            if(cur1.no >= cur2.no){
                resultTemp.next = new NodeList(cur2.no,"","");
                resultTemp = resultTemp.next;
                cur2 = cur2.next;
            }else {
                resultTemp.next = new NodeList(cur1.no,"","");
                resultTemp = resultTemp.next;
                cur1 = cur1.next;
            }
        }
        //便利链表
        return result;
    }
}


/**
 * 定义一个链表节点  ，每一个对象就是一个节点
 */
class NodeList {

    public int no;
    public String name;
    public String nickName;
    public NodeList next;

    public NodeList(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "NodeList{" +
                "no='" + no + '\'' +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
