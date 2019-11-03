/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class PublicNode {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null || pHead2 == null){
            return null;
        }
        for(ListNode cur = pHead1;cur != null; cur = cur.next){
            for(ListNode node = pHead2;node != null; node = node.next){
                if(cur.val == node.val){
                    return cur;
                }
            }
        }
        
        return null;
    }
}