import java.util.Scanner;

public class IsValidTriangle{
	
	public static void main(String[] args){
		
		int[] array = new int[3];
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("请输入三个数：");
		
		for(int i = 0;i<3;i++){
			array[i] = input.nextInt();
		}
		
		java.util.Arrays.sort(array);
				
		if(array[0]+array[1]>array[2] && array[2]-array[0]<array[1]){
			System.out.println("你输入的是有效的三角形");
		}else{
			System.out.println("你输入的是无效的三角形");
		}
	}
}