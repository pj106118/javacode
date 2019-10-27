/*
 public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/

public class DeleteNode  {
    public ListNode deleteDuplication(ListNode pHead){
             if(pHead == null){
            return null;
        }
        ListNode newHead = new ListNode(-1);
        ListNode pre = newHead;
        ListNode cur = pHead;
        
        while(cur != null){
            if(cur.next != null && cur.next.val == cur.val){
                while(cur.next != null && cur.next.val == cur.val){
                    cur = cur.next;
                }
                cur = cur.next;
                newHead.next = cur;
            }else{
                newHead.next = cur;
                newHead = cur;
                cur = cur.next;
            }

           
        }
         return pre.next;
    }
}