package jing.able.DS.SuperList;

/**
 * @author : panjing
 * @data : 2019/9/3 20:32
 * @describe :  线性表
 */
public class List {
    protected int size = 0;

    public void insert(int index,int element){

    }
    public void pushFront(int element){
        insert(0,element);
    }
    public void pushBack(int element){
        insert(size,element);
    }
}
