import java.util.*;
 public class Main{
    public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		while(sc.hasNext()){
			int n=sc.nextInt();
			System.out.println(rabbit(n));
		}
		sc.close();
	}
	//递归三要素 
	//1.必须要写一个方法 
	//2.要有出口条件 
	//3.必须有一定的规律
	public static int rabbit(int n){
		if(n<=2){
			//月份小于等于2只有一个兔子
		return 1;
		}else{
			return rabbit(n-1)+rabbit(n-2);
		} 
	}
}