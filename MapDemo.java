package jing.able.Java.Map;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : panjing
 * @data : 2019/9/8 10:45
 * @describe :
 */
public class MapDemo {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        System.out.println(map.size());
        System.out.println(map.isEmpty());
        System.out.println("==================");
        System.out.println(map.get("老师"));
        System.out.println("================");
        System.out.println(map.put("老师","高老师"));    //返回一个原来key上的值，如果没有就返回默认值
        System.out.println(map.put("课程","数据结构"));
        System.out.println(map.put("时间","2018"));
        System.out.println(map.containsKey("老师"));
        System.out.println(map.containsKey("2018"));
        System.out.println(map.size());
        System.out.println(map.isEmpty());
        System.out.println("==================");
        for (Map.Entry<String,String> s:map.entrySet()) {
            System.out.println(s.getKey()+"="+s.getValue());
            System.out.println();
        }
    }
}
