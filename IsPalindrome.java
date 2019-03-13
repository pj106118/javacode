import java.util.Scanner;

public class IsPalindrome{
	public static void main(String[] args){
		
		System.out.print("请输入一个三位数：");

        int num = new Scanner(System.in).nextInt();

		
		while (num < 100 || num > 999) {
			System.out.println("你输入的不是一个三位数！\n");
			System.out.print("请输入一个三位数：");
			num = new Scanner(System.in).nextInt();
			}
			String tempA,tempB="";//将输入好的三位数转成字符串类型
			tempA=" " + num +" ";//将转换好的三位数字符串按每个字符反向输出，并放入tempB当中
			for (int i = tempA.length(); i > 0; i--) {
				tempB += tempA.substring(i-1, i);   
				}
            //当反向输出的字符串和原字符串一样时候，
			//那个数就是一个回文数，否则就不是一个回文数
			if (tempA.equalsIgnoreCase(tempB)) {
				System.out.println("这个数是一个回文数！");
				}else{
					System.out.println("这个数不是一个回文数！");
				}
	}
}

