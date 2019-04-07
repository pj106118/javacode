package jing.able.dao;


import jing.able.impl.CLinkList;

/**
 * @author panjing
 * @describe:   带头循环单链表
 * @date 2019/4/7
 * @time 10:35
 */

public class CHeadLinkList implements CLinkList {

    class Node {
        private Node next;
        private int data;
        public Node(){
            //标志头节点
            this.data = -1;
        }

        public Node(int data){
            this.data= data;
        }
    }
    private Node head;

    public CHeadLinkList(){
        this.head = new Node();
        this.head.next = this.head;
    }
    @Override
    public void addFirst(int data) {
        Node node = new Node(data);
        node.next = this.head.next;
        this.head.next = node;
    }

    @Override
    public void addLast(int data) {
        Node node =new Node(data);
        Node cur = this.head;
        while(cur.next != this.head){
            cur = cur.next;
        }
        node.next = this.head;
        cur.next = node;
    }

    private void cheackIndex(int index ){
        if (index < 0 || index > getLength()){
            throw new UnsupportedOperationException("插入不合法");
        }
    }
    @Override
    public boolean addindex(int index, int data) {
        cheackIndex(index);
        Node node =new Node(data);
        Node cur = this.head;
        for(int i = 1; i<index;i++){
            cur = cur.next;
        }
        node.next = cur.next;
        cur.next = node;
        return true;
    }

    @Override
    public boolean contains(int key) {
        Node cur = this.head.next;
        while(cur != this.head ){
            if(cur.data== key){
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    private Node searchPre(int key){
        Node pre = this.head;
        while(pre.next != this.head){
            if (pre.next.data == key){
                return pre;
            }
            pre = pre.next;
        }
        return null;
    }


    @Override
    public int remove(int key) {
        Node pre = searchPre(key);
        if (pre == null) {
            throw new UnsupportedOperationException("key不是一个节点");
        }
        int oldData = 0;
        Node delNode = pre.next;
        oldData = delNode.data;
        pre.next = delNode.next;
        return oldData;
    }

    @Override
    public void removeAllKey(int key) {
        Node cur = this.head.next;
        Node pre = this.head;
        while(cur != this.head){
            if(cur.data == key){
                pre.next = cur.next;
                cur = cur.next;
            }else{
                pre = cur;
                cur = cur.next;
            }
        }
    }

    @Override
    public int getLength() {
        Node cur = this.head.next;
        int count = 0;
        while(cur !=this.head){
            count++;
            cur = cur.next;
        }
        return count;
    }

    @Override
    public void display() {
        Node cur = this.head.next;
        while(cur !=this.head){
            System.out.println(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    @Override
    public void clear() {

        while(this.head.next !=this.head){
            Node cur = this.head.next;
            this.head.next = cur.next;
            cur.next = null;
        }
        this.head.next = null;
    }
    
}
