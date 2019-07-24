import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry; 
import java.util.Scanner; 

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        //商人输入 
		String have = sc.nextLine();
		//用户输入 
		String need = sc.nextLine();
		//商人手上每个珠子的数量统计
		Map<Character, Integer> h = new HashMap<>();
		for (char c : have.toCharArray()) {
			if (h.containsKey(c)) {
				h.put(c, h.get(c) + 1);
			} else {
					h.put(c, 1);
			} 
		}
        //用户手上每个珠子的数量统计
		Map<Character, Integer> n = new HashMap<>(); 
		for (char c : need.toCharArray()) {
			if (n.containsKey(c)) { 
			    n.put(c, n.get(c) + 1);
            } else { 
                n.put(c, 1);
            }
        }
        //计算差值，以用户为参考
		boolean weatherBy = true; 
        int lack = 0;
        for (Entry<Character, Integer> en : n.entrySet()) { 
            char k = en.getKey();
            int v = en.getValue();
            if (h.containsKey(k) && h.get(k) < v) {
            //商人的珠子包含用户的珠子但是不够
                weatherBy = false;
                lack += v - h.get(k);
            } else if (!h.containsKey(k)) {
              //商人的珠子不包含用户的珠子 
                weatherBy = false;
                lack += v; 
            } 
        }
        if (weatherBy) {
            System.out.println("Yes " + (have.length() - need.length()));
        } else{ 
		    System.out.println("No " + lack);
        }
    }
}