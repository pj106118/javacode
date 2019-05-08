package jing.able;

/**
 * @author: panjing
 * @describe: 定义一个抽象的"Role"有姓名，年龄，性別等成员变量
 * 1)要求尽可能隐藏所有変量(能够私有就私有，能够保护就不要公有)，
 * 再通过Getter()和Setter()方法対各变量进行读写。具有一个抽象的play()方法、
 * 该方法不返回任何值，同时至少定义两个构造方法。Role类中要体现出this的几种用法。
 * 2)从Role类派生出一个"Employee"类，该类具有Role类的所有成员(构造方法除外)
 * 并扩展salary成员变量,同时増加一个静态成员变量“职工编号(ID) "。
 * 同样要有至少两个构造方法，要体现出this和super的几种用法,还要求覆盖play()方法，
 * 并提供一个final sing()方法。
 * 3)"Manager"类继承"Employee"类.有一个final成员变量" vehicle"
 * 在main()方法中制造Manager和Employe对象,并测试这些对象的方法。
 * @date: 2019/4/25
 * @time: 13:24
 */

public class AbstractRole {
    public static void main(String[] args) {
        Role role = new Employee("zhangsan",18,100000);
        role.play();
    }
}
abstract class Role{
    /**
     * 用private修饰，故需要用getter和setter来获取和修改
     */
    private String name;
    private int age;
    private String sex;

    public abstract void play(); //抽象方法

    public Role(String name,int age){
        this.name = name;
        this.age = age;
    }
    public Role(String name,int age,String sex){
        this(name,age);   //调用上面的构造方法
        this.sex = sex;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
}

class Employee extends Role{
    public  double salary;
    public static int ID;
    public Employee(String name, int age,double salary) {
        super(name, age);
        this.salary = salary;
    }
    public Employee(String name, int age, String sex,double salary) {
        super(name, age, sex);
        this.salary = salary;
    }

    @Override
    public void play() {
        System.out.println(this.getName() + "在"+this.getAge()+"玩游戏");
    }   //覆写抽象类Role的方法
    public final void sing(){
    System.out.println(this.getName()+"在唱歌");
    }
}

class Manager extends Employee {
    public static final String vehicle = "Benz";
    public Manager(String name, int age, double salary) {
        super(name, age, salary);
    }
}











