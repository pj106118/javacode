//替换空格
public class ReplaceSpace {
    //第一种方法：调用自带函数replace() 直接替换
	public String replaceSpace1(StringBuffer str) {
    	return str.toString().replace(" ","%20");
    }
	//第二种方法：用新的数组存
    public String replaceSpace2(StringBuffer str) {
    	if(str == null){
            return null;
        }
        StringBuffer s = new StringBuffer();
        for(int i = 0;i<str.length();i++){
           char c = str.charAt(i);
            if(c == ' '){   //是两个字符串在比较
                s.append("%20");
            }else{
                s.append(c);
            }
        }
        return s.toString();
    }	
}