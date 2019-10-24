//输入一个链表,按链表从尾到头的顺序返回一个ArrayList 
import java.util.*;
class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
           this.val = val;
        }
    }

public class PrintList {
	ArrayList<Integer> list2 = new ArrayList<>();
    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) { 
        ArrayList<Integer> list = new ArrayList<>();	
        ListNode a = listNode;
        while(a != null){
            list.add(0,a.val);
            a=a.next;
        }
        return list;
    }	
    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        if(listNode != null){
            printListFromTailToHead2(listNode.next);
            list2.add(listNode.val);
        }
        return list2;
    }
}
 
 
 
 
 
 