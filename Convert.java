package jing.able.OJ;



/**
 * @author : panjing
 * @data : 2019/12/24 10:37
 * @describe :   输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
import java.util.*;
public class Convert {
        public TreeNode Convert(TreeNode pRootOfTree) {
            if(pRootOfTree == null){
                return null;
            }
            Stack<TreeNode> stack = new Stack<>();
            List<TreeNode> list = new LinkedList<>();
            TreeNode cur = pRootOfTree;
            while(cur != null || !stack.isEmpty()){
                while(cur != null){
                    stack.push(cur);
                    cur = cur.left;
                }
                if(!stack.isEmpty()){
                    cur = stack.pop();
                    list.add(cur);
                    cur = cur.right;
                }
            }
            for(int i = 0; i < list.size() - 1; i++){
                list.get(i).right = list.get(i + 1);
                list.get(i + 1).left = list.get(i);
            }
            return list.get(0);
        }

}
