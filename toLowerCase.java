//实现函数 ToLowerCase()，该函数接收一个字符串参数 str，
//并将该字符串中的大写字母转换成小写字母，之后返回新的字符串。
public class toLowerCase {
    public String toLowerCase(String str) {
        if(str == null){
            return null;
        }
        char[] result = new char[str.length()];
        for(int i = 0;i<str.length();i++){
           char a = str.charAt(i);
            if(a>='A'&&a<='Z'){
                a = (char)(a+32);    
            }
            result[i] = a;
        }
        return new String(result);
    }
}