
//输入一个字符串,按字典序打印出该字符串中字符的所有排列。
//例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串
//abc,acb,bac,bca,cab和cba。
import java.util.*;
public class TotalOrder {
    public ArrayList<String> Permutation(String str) {
        List<String> list = new ArrayList<String>();
        if(str != null && str.length()>0){
            totalOrder(str.toCharArray(),0,list);
            Collections.sort(list);
        }
        return (ArrayList)list;
    }
    public void totalOrder(char[] chars,int index,List<String> list){
        if(index == chars.length-1){
            String value = String.valueOf(chars);
            if(!list.contains(value)){
                list.add(value);
            }
            
        }else{
            for(int i = index;i<chars.length;i++){
                swap(chars,i,index);
                totalOrder(chars,index+1,list);
                swap(chars,i,index);
            }
        }
    }
    public void swap(char[] s,int i,int j){
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }
}