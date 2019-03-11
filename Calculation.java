
import java.util.Scanner;

public class Calculation{

    public static void main(String[] args) {
		
          Scanner input = new Scanner(System.in);
		  
		  int residue;
          int days;
		  
		  System.out.print("Enter minute:");
		  
          int minute = input.nextInt();
		  
          residue = minute % 525600;
          days = residue / 1440;
		  
          int years = (minute-residue) / 525600; 
		  
               System.out.println("the years is "+years+" years "+
			   " and days is "+ days");
    }
    
}