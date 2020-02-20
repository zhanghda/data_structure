package com.zhd.linkedList;

/**
 *
 */
public class SingleLinkedListDemo {

    public static void main(String[] args) {

        NodeList node1 = new NodeList(1, "松江", "");
        NodeList node2 = new NodeList(2, "松江2", "");
        NodeList node3 = new NodeList(3, "松江3", "");
        NodeList node4 = new NodeList(4, "松江4", "");

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
        System.out.println();
        //修改

        sinpleLinkedList.update(new NodeList(1,"1","1"));

        sinpleLinkedList.show();
        System.out.println();

        //删除链表节点
        sinpleLinkedList.delete(1);
        sinpleLinkedList.delete(4);
        sinpleLinkedList.delete(2);
        sinpleLinkedList.delete(3);
        sinpleLinkedList.show();
    }
}

/**
 * 定义一个类来管理链表
 */
class SinpleLinkedList{
    //先创建一个头结点 ，头节点不要动  不存放具体的数据
    private NodeList head = new NodeList(0,"","");

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
    void addByOrder(NodeList nodeList){
        //定义一个临时节点temp 指向头指针  ，用于帮助找到添加节点的位置
        //我们要找到插入位置的前一个结点，否则加入不了  因为单向链表不能往头的方向找
        NodeList temp = head;
        //定义一个flag 用于表示是否有重复 的节点
        boolean flag = false;
        while (true){
            if(temp.next == null){ //该链表已经位于链表最后
                break;
            }
            if(temp.next.no == nodeList.no){  //编号存在
                flag = true;
                break;
            }
            if(temp.next.no > nodeList.no){ //说明位置找到
                break;
            }
            temp = temp.next;
        }
        if(flag){
            System.out.println("编号重复了");
        }else {
            nodeList.next = temp.next;
            temp.next = nodeList;
        }
    }
    /**
     * 修改链表 根据id修改链表
     *
     */
    void update(NodeList nodeList){
        NodeList temp = head; //定义临时指针
        boolean flag = false; //如果找到id相同的节点  flag为true

        while(true){
            if(temp.next == null){  //表示元素已到达最后一个的节点 跳出循环
                break;
            }
            if(temp.next.no == nodeList.no){ //说明已经找到该节点
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            temp.next.name = nodeList.name;
            temp.next.nickName = nodeList.nickName;
        }else {
            System.out.println("并没有与之匹配的元素");
        }
    }

    /**
     * 删除
     *
     * 注意：我们要找到待删除结点的前一个结点   如果找到的是待删除节点  找不到它的上一个节点，导致链表连不上
     *
     * 被删除的节点将不会有其他引用指向，将直接会被垃圾回收机制回收
     */
    void delete(int no){
        NodeList temp  = head;
        boolean flag = false;  //找到要删除的节点时 为false
//        if(temp.next == null){  //链表为空
//            System.out.println("链表为空");
//            return;
//        }
        while (true){
            if(temp.next == null){ //已经到达链表的尾部
                break;
            }
            if(temp.next.no == no){
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if(flag){
            temp.next = temp.next.next;
        }else {
            System.out.println("链表不存在");
        }

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

    public int no;
    public String name;
    public String nickName;
    public NodeList next;

    public NodeList(int no,String name,String nickName){
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
