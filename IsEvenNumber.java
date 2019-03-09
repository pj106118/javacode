import java.util.Scanner;

public class IsEvenNumber{
	
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("请输入一个数：");
		
		int num = input.nextInt();
		
		if(num % 2 == 0){
				System.out.println(" 你输入的数 " + num +" 是偶数 ");
				} else {
				System.out.println("你输入的数 " + num +" 不是偶数");
				}
	}
}