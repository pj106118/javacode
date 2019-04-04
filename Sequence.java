package jing.able.dao;

import jing.able.impl.ISequence;

import java.util.Arrays;
/**
 * @author panjing
 * @describe:
 */

public class Sequence implements ISequence {

    private Object[] elemData;
    private int usedSize;
    public static final int DEFAULT_CAPACITY= 10;

    public void SequenceImpl(){
        this.elemData = new Object[DEFAULT_CAPACITY];
        this.usedSize = 0;
    }
    private boolean isFull(){
        return this.usedSize == this.elemData.length;
    }
    @Override
    public boolean add(int pos, Object data) {
        //1.判断POS的合法性，放入数据后是否会发生溢出
        if (pos < 0 || pos > this.usedSize) {
            return false;
        }
        if (isFull()) {
            //扩容
            this.elemData = Arrays.copyOf(this.elemData, this.elemData.length * 2);
        }
        //2.挪数据
        int i = usedSize;
        for (i = usedSize; i >= pos; i--) {
            this.elemData[i + 1] = this.elemData[i];
        }
        //3.放入数据
        this.elemData[pos] = data;
        this.usedSize++;
        return true;
    }

    private boolean isEmpty(){
        return this.usedSize == 0;
    }
    @Override
    public int search(Object key) {
        if(key==null){
            throw new UnsupportedOperationException("不可以传null作为参数");
        }
        if(isEmpty()){
            return -1;
        }
        for(int i = 0;i<=this.usedSize;i++){
            if(this.elemData[i].equals(key)){ //equals比较数值大小
                return 1;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(Object key) {
        if(key==null){
            throw new UnsupportedOperationException("不可以传null作为参数");
        }
        if(isEmpty()){
            return false;
        }
        for(int i = 0;i<=this.usedSize;i++){
            if(this.elemData[i].equals(key)){ //equals比较数值大小
                return true;
            }
        }
        return false;
    }

    @Override
    public Object getPos(int pos) {
        if(pos<0||pos>=this.usedSize){
            return null;
        }
        return this.elemData[pos];
    }

    @Override
    public Object remove(Object key) {
        int index = search(key);
        if(index==-1){
            return null;
        }
        Object oldData=this.elemData[index];
        int i =0;
        for (i = index; i < this.usedSize-1; i++) {
            this.elemData[i] = this.elemData[i+1];
        }
        this.elemData[i+1] = null;
        this.usedSize--;
        return oldData;
    }

    @Override
    public int size() {
        return this.usedSize;
    }

    @Override
    public void display() {
        for (int i = 0; i <this.usedSize ; i++) {
            System.out.println(this.elemData[i]);
        }
    }

    @Override
    public void clear() {
        for (int i = 0; i <this.usedSize ; i++) {
            this.elemData[i] = null;
        }
        this.usedSize=0;
    }
}
