import java.util.Scanner;

public class Yingchi {

public static void main(String[] args) {

         Scanner input = new Scanner(System.in);

         double meter;

         System.out.print("Enter yingchi;");
		 
         double yingchi = input.nextDouble();
		 
         meter = yingchi*0.305;
		 
         System.out.println("meter = "+ meter);
         
    }
    
}