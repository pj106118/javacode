package jing.able.dao;

import jing.able.impl.IDoubleLinked;

/**
 * @author panjing
 * @describe:  双向链表
 * @date 2019/4/7
 * @time 12:03
 */

public class DoubleLinkList implements IDoubleLinked {
    class Node {
        private int data; //数据
        private Node prev;//前驱
        private Node next;//后驱

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    private Node head;
    private Node last;     //last记录着链表的结尾

    public DoubleLinkList() {
        this.head = null;
        this.last = null;
    }

    @Override
    public void addFirst(int data) {
        Node node = new Node(data);
        if (head == null) {      //第一次插入
            this.head = node;
            this.last = node;
        } else {
            node.next = this.head;
            node.next.prev = node;
            this.head = node;
        }
    }

    @Override
    public void addLast(int data) {
        Node node = new Node(data);
        if (head == null) {      //第一次插入
            this.head = node;
            this.last = node;
        } else {
            this.last.next = node;
            node.prev = this.last;
            this.last = node;
        }
    }

    private Node seachIndex(int index) {
        cheackIndex(index);
        Node cur = this.head;
        int count = 0;
        while (count < index) {
            cur = cur.next;
            count++;
        }
        return cur;
    }

    private void cheackIndex(int index) {
        if (index < 0 || index > getLength()) {
            throw new UnsupportedOperationException("插入不合法");
        }
    }

    @Override
    public boolean addindex(int index, int data) {
        if (index == 0) {
            addFirst(data);
            return true;
        }
        if (index == getLength()) {
            addLast(data);
            return true;
        }
        Node node = new Node(data);
        Node cur = seachIndex(index);
        node.next = cur;
        cur.prev.next = node;
        node.prev = cur.prev;
        cur.prev = node;
        return true;
    }

    @Override
    public boolean contains(int key) {
        Node cur = this.head;
        while (cur != null) {
            if (cur.data == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    @Override
    public int remove(int key) {
        Node cur = this.head;
        while (cur != null) {
            if (cur.data == key) {
                int oldData = cur.data;
                //删除的是头节点
                if (cur == this.head) {
                    this.head = this.head.next;
                    this.head.prev = null;
                } else {
                    //删除普通节点
                    cur.prev.next = cur.next;
                    if (cur.next != null) {
                        cur.next.prev = cur.prev;
                    } else {
                        //删除最后一个节点，last需要指回来
                        this.last = cur.prev;
                    }
                }
                return oldData;
            }
            cur = cur.next;
        }
        return -1;
    }

    @Override
    public void removeAllKey(int key) {
        Node cur = this.head;
        while (cur != null) {
            if (cur.data == key) {
                //删除的是头节点
                if (cur == this.head) {
                    this.head = this.head.next;
                    this.head.prev = null;
                } else {
                    //删除普通节点
                    cur.prev.next = cur.next;
                    if (cur.next != null) {
                        cur.next.prev = cur.prev;
                    } else {
                        //删除最后一个节点，last需要指回来
                        this.last = cur.prev;
                    }
                }
            }
            cur = cur.next;
        }
    }

    @Override
    public int getLength() {
        int count = 0;
        Node cur = this.head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        return 0;
    }

    @Override
    public void display() {
        Node cur = this.head;
        while (cur != null) {
            System.out.println(cur.data + " ");
            cur = cur.next;
        }
    }

    @Override
    public void clear() {

        while (this.head != null) {
            Node cur = this.head.next;
            this.head.next = null;
            head.prev = null;
            head = cur;
            this.last = null;
        }
    }


    public Node middleNode(Node head) {
        Node cur = this.head;
        int len = getLength() / 2;
        for (int i = 0; i < len; i++) {
            cur = cur.next;
        }
        return cur;
    }


    public class Solution {
        public Node FindKthToTail(Node head, int k) {

            Node cur = head;
            Node fast = head;
            Node slow = head;
            int len = 0;
            while (cur != null) {
                len++;
                cur = cur.next;
            }
            if (fast == null || k <= 0 || k > len) {
                return null;
            }
            for (int i = 0; i < k; i++) {
                fast = fast.next;
            }
            while (fast.next != null) {
                fast = fast.next;
                slow = slow.next;
            }
            return slow;

        }
    }


    public Node mergeTwoLists(int x) {
        Node beforStart = null;
        Node beforEnd = null;
        Node afterStart = null;
        Node afterEnd = null;
        Node pHead = this.head;

        while (pHead != null) {
            Node pHeadNext = pHead.next;
            pHead.next = null;
            if (pHead.data < x) {
                if (beforStart == null) {
                    beforStart = pHead;
                    beforEnd = beforStart;
                } else {
                    beforEnd.next = pHead;
                    beforEnd = beforEnd.next;
                }
            } else {
                if (pHead.data > x) {
                    if (afterStart == null) {
                        afterStart = pHead;
                        afterEnd = afterStart;
                    } else {
                        afterEnd.next = pHead;
                        afterEnd = afterEnd.next;
                    }
                }
                pHead = pHeadNext;
            }
            if (beforStart == null ){
                return afterStart;
            }
            beforEnd.next = afterStart;
            return beforStart;
        }

        return beforStart;
    }
}
