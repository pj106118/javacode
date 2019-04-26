package jing.able;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * @author: panjing
 * @describe:  给定一个字符串，打印出首先出现三次的字符
 * @date: 2019/4/25
 * @time: 20:35
 */

public class RepeatChar {
    public static void main(String[] args) {
    }
    public static char findRepeatCharNumber(String value){
        if (value == null || value.length()==0){
            throw new UnsupportedOperationException("value must be not null/empty");
        }
        int[] counter = new int[255];
        char[] chars = value.toCharArray();
        for (int i = 0; i <chars.length ; i++) {
            char c = chars[i];
            if (c > 'a'&& c< 'z'|| c > 'A'&& c< 'Z'){
                counter[c]++;
            }
            if (counter[c]==3){
                return c;
            }
        }
        throw new RuntimeException("Not found three times char");

    }
}
