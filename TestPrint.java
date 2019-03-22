package jing.able;

public class TestPrint {
    public static void main(String args[]) {
        int a = (int) (Math.random() * 58) + 65; //随机产生一个字符
        System.out.println("转换前： " + (char) a);
        int b = a > 97 ? a & 0xdf : a;//位运算转换为大写字母
        char c = (char) b;
        System.out.println("转换后： " + c);
    }
}