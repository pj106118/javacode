//隔两个数就删除，输出剩到最后的数的最开始的下标是多少
import java.util.*;
 public class DeleteNumber {
	 public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 while (sc.hasNext()) {
			 int n = sc.nextInt();
			 if (n > 1000) {
				 n = 999; 
			}
			List<Integer> list = new ArrayList<Integer>();
			for (int i = 0; i < n; i++) {
				list.add(i);
			}
			int i = 0;
			while (list.size() > 1) {
				i = (i + 2) % list.size();
				list.remove(i);
			}
			System.out.println(list.get(0));
		} 
	} 
}