package com.zhd.linkedList;

/**
 *
 */
public class SingleLinkedListDemo {

    public static void main(String[] args) {

        NodeList node1 = new NodeList("1", "松江", "");
        NodeList node2 = new NodeList("2", "松江2", "");
        NodeList node3 = new NodeList("3", "松江3", "");
        NodeList node4 = new NodeList("4", "松江4", "");

        SinpleLinkedList sinpleLinkedList = new SinpleLinkedList();
        sinpleLinkedList.add(node1);
        sinpleLinkedList.add(node2);
        sinpleLinkedList.add(node3);
        sinpleLinkedList.add(node4);

        sinpleLinkedList.show();
    }
}

/**
 * 定义一个类来管理链表
 */
class SinpleLinkedList{
    //先创建一个头结点 ，头节点不要动  不存放具体的数据
    private NodeList head = new NodeList("0","","");

    /**
     * 添加方法
     * 思路：不考虑排序
     * 具体操作：
     * 1.找到这个链表的最后一个节点
     * 2.然后往这个节点后面添加  要添加的节点
     */
    void add(NodeList nodeList){
        //先定义一个临时节点，  temp变量指向头结点
        NodeList temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = nodeList;
    }
    /**
     * 展示链表
     */
    void show(){
        if(head.next == null){
            System.out.println("链表为空");
        }
        NodeList temp = head;
        while (temp.next != null){
            System.out.println(temp.next);
            temp = temp.next;
        }
    }
}
/**
 * 定义一个链表节点  ，每一个对象就是一个节点
 */
class NodeList{

    private String no;
    private String name;
    private String nickName;
    public NodeList next;

    public NodeList(String no,String name,String nickName){
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
