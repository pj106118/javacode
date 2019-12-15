import java.util.Scanner;
//输入一段字符串，输出指定长度的字符串，并且该字符串中指定字符所占比例最高。
public class PrintString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int n = sc.nextInt();
        
        
        int start = 0;
        int max = 0;
        for(int i = 0;i<=str.length()-n;i++){
            int count = 0;
            for(int j = i;j<i+n;j++){
                if(str.charAt(j) == 'G'||str.charAt(j) == 'C'){
                    count ++;
                }
                   if(count > max){
                        max = count;
                        start = i;
                     }
                
           }
       }
            
        for(int i = start;i< start+n;i++){
            System.out.print(str.charAt(i));
        }
        
    }
}
        