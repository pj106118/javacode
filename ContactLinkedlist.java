package jing.able.OJ;

/**
 * @author : panjing
 * @data : 2019/12/1 9:34
 * @describe :  输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class ContactLinkedlist {
            class ListNode {
            int val;
            ListNode next = null;

            ListNode(int val) {
                this.val = val;
            }
        }

        public ListNode Merge(ListNode list1,ListNode list2) {
            ListNode list = new ListNode(-1);//空链表
            ListNode head = list;
            if(list1 == null){
                return list2;
            }
            if(list2 == null){
                return list1;
            }
            while(list1 != null && list2 != null){
                if(list1.val > list2.val){
                    list.next = list2;
                    list2 = list2.next;
                }else{
                    list.next = list1;
                    list1 = list1.next;
                }
                list = list1.next;
            }
            if(list1 != null){
                list.next = list1;
            }
            if(list2 != null){
                list.next = list2;
            }
            return head.next;
        }

}
