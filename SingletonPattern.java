package jing.able;

/**
 * @author: panjing
 * @describe: 单例
 * @date: 2019/4/25
 * @time: 19:56
 */

/**
 * 单例：
 * 一个类只有一个实例化对象
 * 1.构造方法私有
 * 2.提供一个静态方法用于返回对象
 * 3.多次调用静态方法的对象必须是同一个
 * 4.定义一个静态的属性对象表示当前类的对象
 */
public class SingletonPattern {
    public static void main(String[] args) {
        SingletonA singletonA = null;
        singletonA = singletonA.getInstance();
    }
}
//饿汉式单例：
// 立即实例化
class SingletonA{
    public static final SingletonA INSTANCE = new SingletonA();
    private SingletonA(){
    }
    public static SingletonA getInstance(){
        return INSTANCE;
    }
    public void print(){
        System.out.println("hahaha A");
    }
}
//懒汉式单例
//延迟实例化对象
class SingletonB {
    private static SingletonB instance;
    private SingletonB() {
    }
    public static SingletonB getInstance() {
        if (instance == null) {
            instance = new SingletonB();
        }
        return instance;
    }
    public void print() {
        System.out.println("hahaha B");
    }
}