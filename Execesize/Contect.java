package jing.able.OJ.Execesize;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author : panjing
 * @data : 2019/10/24 21:24
 * @describe :
 */
public class Contect {
    Map<String,User> map = new TreeMap<>();

    public void add(String name, String mobilePhone, String officePhone) throws Exception{
        User user = new User(name,mobilePhone,officePhone);
        if(map.containsKey(name)){
            throw new Exception("用户已存在！");
        }
        map.put(name,user);
    }

    public User select(String name) {
        if(map.containsKey(name)){
            User use = map.get(name);
            return use;
        }
        return null;
    }

    public boolean remove(String name) {
        if(map.containsKey(name)){
            map.remove(name);
            return true;
        }

        return false;
    }

    public boolean update(String name, String mobilePhone, String officePhone) {
        if(map.containsKey(name)){
            User  user = new User(name,mobilePhone,officePhone);
            map.put(name,user);
            return true;
        }
            return false;

    }
}
