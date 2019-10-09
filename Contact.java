package jing.able.DS.BinTree;

/**
 * @author : panjing
 * @data : 2019/10/8 19:29
 * @describe :  电话本
 */
public class Contact {
    class Node {
        String name;
        String phone;

        Node left;
        Node right;
    }
    Node root = null;

    public String seach(String name ){
        Node cur = root;
        int r = name.compareTo(cur.name);
        while(cur != null){
            if(r == 0){
                return cur.phone;
            }else if(r < 0){
                cur = cur.left;
            }else{
                cur = cur.right;
            }
        }
        return null;
    }

    public String update(String name,String phone) {
        Node cur = root;
        String oldphone = null;
        int r = name.compareTo(cur.name);
        while (cur != null) {
            if (r == 0) {
                oldphone = cur.phone;
                cur.phone = phone;
            } else if (r < 0) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        return oldphone;
    }

    public Boolean insert(String name,String phone){
        Node cur = root;
        Node parent = null;
        if(cur == null){
            root.name = name;
            root.phone = phone;
            return true;
        }
        int r = name.compareTo(cur.name);
        while(cur != null){
            if(r == 0){
                return false;
            }else if(r < 0){
                parent = cur;
                cur = cur.left;
            }else{
                parent = cur;
                cur = cur.right;
            }
        }
        int p = name.compareTo(parent.name);
        if(p < 0){
            parent.left.name = name;
            parent.left.phone = phone;
        }else{
            parent.right.name = name;
            parent.right.phone = phone;
        }
        return true;
    }



}
