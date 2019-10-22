//输入一个链表,输出该链表中倒数第K个结点。
import java.util.*;

public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class PrintArrayList {
    public ListNode FindKthToTail(ListNode head,int k) {
       if(head == null || k==0){
           return null;
       }
      return check(head,k);
    }
    public ListNode check(ListNode head,int k){
        List<ListNode> list = new ArrayList<>();
        while(head!=null){
            list.add(head);
            head = head.next;
        }
        if(list.size()<k){
            return null;
        }
        return list.get(list.size()-k);
    }
}