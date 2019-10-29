package jing.able.OJ.Execesize;

import java.util.Scanner;

/**
 * @author : panjing
 * @data : 2019/10/24 21:26
 * @describe :
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Contect contect = new Contect();
       while(true){
           //1.先打印菜单
           meun();
           //2.根据选择做事
           int a = sc.nextInt();
           sc.nextLine();
           switch (a){
               case 1:
                   add(sc,contect);break;
               case 2:
                   select(sc,contect);break;
               case 3:
                   remove(sc,contect);break;
               case 4:
                   update(sc,contect);break;
                default:
                    System.out.println("输入格式不正确！");
           }

       }
    }

    private static void update(Scanner sc, Contect contect) {  // 更新
        System.out.println("请输入要更新的用户名：");
        String name = sc.nextLine();
        System.out.println("请输入要更新的手机号：");
        String mobilePhone = sc.nextLine();
        System.out.println("请输入要更新的办公室号：");
        String officePhone = sc.nextLine();

        if(contect.update(name,mobilePhone,officePhone)){
            System.out.println("更新成功！");
        }else {
            System.out.println("该用户不存在，无法更新！");
        }

    }

    private static void remove(Scanner sc, Contect contect) { //删除
        System.out.println("请输入需要删除的用户名：");
        String name = sc.nextLine();
        if(contect.remove(name)){
            System.out.println("删除成功！");
        }else{
            System.out.println("该用户不存在！");
        }
    }

    private static void select(Scanner sc,Contect contect) { //查找

        System.out.println("请输入要查找的姓名：");
        String name = sc.nextLine();
        if(contect.select(name) == null){
            System.out.println("用户不存在！");
        }else{
            System.out.println("用户名称："+ name +"\n " + "查找的电话：" + contect.select(name));
        }
    }


    private static void add(Scanner sc,Contect contect) { //添加
        System.out.println("请输入姓名：");
        String name = sc.nextLine();
        System.out.println("请输入手机号：");
        String mobilePhone = sc.nextLine();
        System.out.println("请输入办公室电话：");
        String officePhone = sc.nextLine();

        try {
            contect.add(name,mobilePhone,officePhone);
            System.out.println("用户添加成功！");
        } catch (Exception e) {
            System.out.println("添加失败，用户已存在！");
        }finally{
            System.out.println();
        }

    }

    private static void meun() {
        System.out.println("-----------------");
        System.out.println("     通讯录      ");
        System.out.println("     1.添加      ");
        System.out.println("     2.查找      ");
        System.out.println("     3.删除      ");
        System.out.println("     4.更新      ");
        System.out.println(" 请输入你的选择： ");
    }

}
