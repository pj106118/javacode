import java.util.*;
 public class Substr {
     public boolean[] chkSubStr(String[] p, int n, String s) {
	 // 创建boolean数组 
	 boolean[]hasSub=new boolean[p.length];
	 //遍历数组 使用集合中特有功能
	 for (int i = 0; i < p.length; i++) {
	 hasSub[i]=s.contains(p[i]); 
	}
	 return hasSub; 
  }
}