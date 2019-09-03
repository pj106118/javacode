package jing.able.DS.SuperList;

/**
 * @author : panjing
 * @data : 2019/9/3 20:50
 * @describe : 链表
 */
public class LinkedList extends List {
    private Node frist = null;
    @Override
    public void insert(int index, int element) {
        Node node = new Node();
        node.val = element;
        if (index == 0){  //头插
            node.next = frist;
            frist = node;
        }else if(index == size){   //尾
            Node last = frist;
            while(last.next != null){
                last = last.next;
            }
            last.next = node;
            node.next = null;
        }else{
            Node prv = frist;
            for (int i = 0; i < index; i++) {
                prv = prv.next;
            }
            node.next=prv.next;
            prv.next = node;
        }
        size++;
    }
}
class Node{
     int val;
     Node next;
}
