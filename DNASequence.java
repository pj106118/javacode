import java.util.Scanner;
 import java.util.Set;
 import java.util.TreeSet;
 public class Main {
	 public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);
		 String str = scanner.next();
		 Syste out p t ( u (st ));
    }
	static int fun(String str) {
		for (int i = 1; i <= str.length(); i++) {
			Set<String> rq = new TreeSet<>();
			for (int j = 0; j < str.length() - i; j++) {
				rq.add(str.substring(j, j + i));
				//长度为i的 子串 
			}
			if (rq.size() < Math.pow(4, i)) {
				//长度为i的子串没有出现，返回i
				return i; 
			} 
		}
		//字符串包含了所有长度为1的子串，所以此处返回1
		return 1;
	}
}