//编写代码，以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前

//给定一个链表的头指针 ListNode* pHead，请返回重新排列后的链表的头指针。注意：分割以后保持原来的数据顺序不变。
import java.util.*;

/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class ListPartition {
    public ListNode partition(ListNode pHead, int x) {
        ListNode cur = pHead;
        ListNode s = null;
        ListNode sl = null;
        ListNode b = null;
        ListNode bl = null;
        while(cur != null){
            if(cur.val < x){
                if(s == null){
                    s = cur;
                }else{
                    sl.next = cur;
                }
                sl = cur;
            }else{
                if(b == null){
                    b = cur;
                }else{
                    bl.next = cur;
                }
                bl = cur;
            }
            cur = cur.next;
        }
        if(s == null){
            return b;
        }else{
            sl.next = b;
            if(bl!= null){
                bl.next = null;
            }
            
        }
        return s;
    }
}