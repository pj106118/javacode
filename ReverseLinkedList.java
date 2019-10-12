import java.util.*;
//反转链表，输出表头
 class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
public class ReverseLinkedList {
    public ListNode ReverseList(ListNode head) {
        ListNode prev = null;
        ListNode node = null;
        ListNode current = head;
        while(current != null){
            ListNode next = current.next;
            if(next == null){
                node = current;
            }
            current.next = prev;
            prev = current;
            current = next;
        }
        return node;
    }
}