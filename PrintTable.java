package jing.able;

public class PrintTable {
    public static void main(String[] args) {
        System.out.println("千克 "+ "\t" + "磅" + "\t" +  "磅"+ "\t" +"千克 ");
        int k = 1;
        int p =20 ;
        while(k < 200  && p < 520){
            System.out.println(k + "\t" + (k*2.2) + "\t"+ p+"\t" + ( p/2.2));
            k+=2;
            p+=5;
        }
    }
}
