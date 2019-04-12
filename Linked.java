package jing.able.dao;

import jing.able.impl.ILinked;

/**
 * @author panjing
 * @describe:单链表
 * @date 2019/4/3
 * @time 21:06
 */

public class Linked implements ILinked {
    class Node {
        private Node next;
        private int data;
        public Node(int data){
            this.data= data;
            this.next = null;
        }
    }

    private Node head;
    public Linked(){
        this.head = null;
    }

    @Override
    //头插法
    public void addFirst(int data) {
        Node node = new Node(data);
        if (head==null){
            this.head = node;
        }else{
            node.next = this.head;
            this.head = node;
        }
    }

    @Override
    //尾插法
    public void addLast(int data) {
        Node node = new Node(data);
        Node cur = this.head;
        if (cur==null){
            this.head = node;
        }else {
            while (cur.next != null) {
               cur = cur.next;
            }
            cur.next = node;
            node.next = null;
        }
    }

    private void cheackIndex(int index ){
        if (index < 0 || index > getLength()){
            throw new UnsupportedOperationException("插入不合法");
        }
    }

    @Override
    //任意位置插入,第一个数据节点为0号下标
    public boolean addindex(int index, int data) {
        cheackIndex(index);
        Node cur = this.head;
        Node node = new Node(data);
        for (int i = 0;i < index; i++){
            cur = cur.next;
        }
        node.next = cur.next;
        cur.next = node;
        return true;
    }

    @Override
    public boolean contains(int key) {
        Node cur = this.head;
        while(cur.next!=null){
            if(cur.data==key){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    private Node searchPre(int key){
        //1.判断是否为第一个节点
        Node cur = this.head;
        if (cur.data==key){
            return this.head;
        }else{         //2.if(cur.next.data !=key)
            while(cur.next !=null){
                if(cur.next.data == key){
                    return cur;
                }
                cur = cur.next;
            }
            return null;

        }
    }

    @Override
    //删除
    public int remove(int key) {
        Node cur =searchPre(key);
        int oldData=0;
        if (cur.next ==null){
            throw new UnsupportedOperationException("没有节点");
        }
        if (cur==this.head&&cur.data==key){
           oldData = this.head.data;
            this.head=this.head.next;
            return oldData;
        }
        Node delNode = cur.next;
        cur.next = delNode.next;

        return 0;
    }

    @Override
    //删除所有值为key的节点
    public void removeAllKey(int key) {
        Node pre = this.head;
        Node cur = this.head.next;
        while(cur != null){
            if (cur.data == key){
                pre.next = cur.next;
                cur = cur.next;
            }else{
                pre = cur;
                cur = cur.next;
            }
        }
        if (this.head.data==key){
            this.head=this.head.next;
        }
    }

    @Override
    public int getLength() {
        int count = 0;
        Node cur = this.head;
        while(cur.next != null){
            count++;
            cur = cur.next;
        }
        return count;
    }

    @Override
    public void display() {
        Node cur = this.head;
        while(cur.next != null){
            System.out.println(cur.data+" ");
            cur = cur.next;
        }
    }

    @Override
    //清除
    public void clear() {
        while(this.head !=null){
            Node cur = this.head.next;
            this.head = null;
            head = cur;
        }

    }
}
