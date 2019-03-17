import java.util.Scanner;

public class CalculationVolume{
	
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("请输入两个数：");
		
		double radius = input.nextInt();
		
		double length = input.nextInt();
		
		double num = 3.1415926;
		
		double area = radius * radius * num;
		
		double volume = area * length;
		
		System.out.println("The area is " + area);
		
		System.out.println("The Volume is " + volume);
		
	}
	
}