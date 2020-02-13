package com.able.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author : panjing
 * @data : 2019/11/11 14:56
 * @describe :  封装所有公共操作，包括加载配置文件、json等
 *
 * 类的方法测试：ctrl + shift + t 产生相应的测试类
 */
public class CommUtil {

    private static final Gson GSON = new GsonBuilder().create(); //建造者模式（xx.creat() ）
    public static Properties loadProperties (String fileName){
        Properties properties = new Properties();
        InputStream in = CommUtil.class.getClassLoader()  //获取类加载器
                .getResourceAsStream(fileName);  //读取源文件同目录下的resource资源文件夹

        //把资源文件变成输入流
        try {
            properties.load(in);  //把输入流加载进来
        } catch (IOException e) {
            System.out.println("资源文件加载失败！");
            e.printStackTrace();
            return null;
        }
        return properties;

    }

    /**
     * 将任意对象序列化为json字符串（调用第三方类库的一个方法）
     * @param obj
     * @return
     */
    public static String object2Json(Object obj){
        return GSON.toJson(obj);
    }

    /**
     * 将json字符串反序列化为对象
     * @param jsonStr
     * @param objClz  序列化对象的反射对象
     * @return
     */
    public static Object json2Object(String jsonStr,Class objClz){
        return GSON.fromJson(jsonStr,objClz);
    }
}
