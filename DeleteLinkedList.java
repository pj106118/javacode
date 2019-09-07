package jing.able.DS.linkedlist;

/**
 * @author : panjing
 * @data : 2019/9/5 18:47
 * @describe :  删除有序链表中重复的结点
 */
public class LinkedList {

    public static Node delete(Node head){
        Node node = new Node();
        Node pre = node;
        node.next = head;
        Node p = head;
        Node q = head.next;
        while( q != null){
            if(p.val != q.val){
                pre = p ;
                p = q;
                q = q.next;
            }else{
                while(q!=null&&q.val==p.val){
                    q = q.next;
                }
                node.next=q;
                p = q;
                if(q != null){
                    q = q.next;
                }
            }
        }
        return node.next;
    }
}
class Node{
    int val;
    Node next;
}