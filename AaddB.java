//有两个用链表表示的整数，每个结点包含一个数位。这些数位是反向存放的，也就是个位排在链表的首部。
// 编写函数对这两个整数求和，并用链表形式返回结果。

public class AaddB {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
        public ListNode plusAB(ListNode a, ListNode b) {
            // write code here
            ListNode list = new ListNode(-1);
            ListNode head = list;
            ListNode p = a;
            ListNode q = b;
            int sum = 0;
            if(a == null){
                return b;
            }
            if(b==null){
                return a;
            }
            while(p != null || q != null || sum !=0){
                if(p!=null){
                    sum += p.val;
                    p = p.next;
                }
                if(q!=null){
                    sum += q.val;
                    q = q.next;
                }
                head.next = new ListNode(sum%10);
                sum /= 10;
                head = head.next;
            }

            return list.next;
        }
}
