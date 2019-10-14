//给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
class Node {
    public int val;
    public Node next;
    public Node random;
    public Node() {}
    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
}
class CopyRandomList {
    public Node copyRandomList(Node head) {
        Map<Node,Node> map = new HashMap<>();
       if(head == null){
           return null;
       }
        Node node = head;
        while(node != null){
            Node cloneNode = new Node(node.val,null,null);
            map.put(node,cloneNode);
            node = node.next;
        }
        
        node = head;
        while(node != null){
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
            node = node.next;
        }
    return map.get(head);
    }
}