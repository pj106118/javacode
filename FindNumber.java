package jing.able;

public class FindNumber {
    public static void main(String[] args){
        int i = 100;
        int num = 0;
        int[] array= {0};
        while(i < 200){
            if(i%5==0 || i%6 == 0){
                System.out.print(i + "\t");
                num ++;
            }
            if(num % 10 == 0){
                System.out.println();
            }
            i++;
        }
    }
}
