import java.util.*;
public class Main{
    public static void main(String[]args){ 
	Scanner in=new Scanner(System.in); 
    int num[]=new int[10];
    //0 - 9
    //输入 0 - 9 这10个数字的出现的个数
    for(int i=0;i<10;i++){ 
        num[i]=in.nextInt();
    }
    //先输出安装1-9的顺序第一个出现的数字1次
    for(int i=1;i<10;i++){
        if(num[i]!=0){
			System.out.print(i); 
			num[i]--;
            break;
			}
		}
        //第二位：输出0
    while(num[0]!=0){ 
	    System.out.print(0);
        num[0]--;
    }
    //最后按照1-9的顺序输出
    for(int i=1;i<10;i++){
        while(num[i]!=0){ 
		System.out.print(i);
         num[i]--;
		 }
    }
  }
}