public class ReplaceSpace2 {
    public String replaceSpace(StringBuffer str) {
    	
        StringBuffer s = new StringBuffer();
        for(int i = 0; i < str.length();i++){
        char c = str.charAt(i);
        if(c == ' '){
            s.append("%20");
        }else{
            s.append(c);
        }
    }
        return s.toString();
}
}