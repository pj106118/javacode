import java.util.Scanner;
//输入任意（用户，成绩）序列，可以获得成绩从高到低或从低到高的排列,相同成绩
//都按先录入排列在前的规则处理。
public class Gradesort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            int flag = sc.nextInt();
            sc.nextLine();
            int[] grade = new int[3];
            String[] str = new String[3];

            for (int i = 0; i < num; i++) {
                str[i] = sc.next();

                grade[i] = sc.nextInt();
            }

            if (flag == 0) {//降序
                for (int i = 1; i < num; i++) {

                    for (int j = i - 1; j >= 0; j--) {
                        if (grade[j] < grade[j + 1]) {
                            int tmp = grade[j];
                            grade[j] = grade[j + 1];
                            grade[j + 1] = tmp;

                            String ass = str[j];
                            str[j] = str[j + 1];
                            str[j + 1] = ass;
                        }
                    }
                }
            } else {
                for (int i = 1; i < num; i++) {

                    for (int j = i - 1; j >= 0; j--) {
                        if (grade[j] > grade[j + 1]) {
                            int tmp = grade[j];
                            grade[j] = grade[j + 1];
                            grade[j + 1] = tmp;

                            String ass = str[j];
                            str[j] = str[j + 1];
                            str[j + 1] = ass;
                        }
                    }
                }
            }
            for (int k = 0; k < num; k++) {
                System.out.println(str[k] + " " + grade[k]);
            }
        }
        sc.close();
    }
}
