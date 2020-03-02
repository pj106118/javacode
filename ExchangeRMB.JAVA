import java.util.Scanner;
public class ExchangeRMB {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int [] GPA = new int[n];

        int V = 0;  //学分和
        for(int i = 0;i<n;i++){
            GPA[i] = in.nextInt();
            V+= GPA[i];
        }
        float sum = 0;
        for(int i= 0;i<n;i++){
            int tmp = in.nextInt();
            if(tmp >=90){
                sum+= 4.0* GPA[i];
            }else if(tmp >=85  ){
                sum+= 3.7* GPA[i];
            }else if(tmp >=82 ){
                sum+= 3.3* GPA[i];
            }else if(tmp >=78 ){
                sum+= 3.0* GPA[i];
            }else if(tmp >=75 ){
                sum+= 2.7* GPA[i];
            }else if(tmp >=72 ){
                sum+= 2.3* GPA[i];
            }else if(tmp >=68 ){
                sum+=2.0* GPA[i];
            }else if(tmp >=64){
                sum+= 1.5* GPA[i];
            }else if(tmp >=60){
                sum+= 1.0* GPA[i];
            }else if(tmp<60){
                sum+= 0;
            }
        }
        System.out.printf("%.2f",sum/V);

    }
}
