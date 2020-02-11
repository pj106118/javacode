/*
给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
*/
class VerifyPalindrome{
    public boolean isPalindrome(String s) {
        String str = "";
        for(int i = 0;i<s.length();i++){
            char a = s.charAt(i);
            if(a>='0'&&a<='9' || a>='a'&&a<='z' || a>='A'&&a<='Z' ){
                str+= a+"";
            }
        }
        str = str.toLowerCase();
        for(int j=0;j<str.length()/2;j++){
            if(str.charAt(j)!=str.charAt(str.length()-1-j)){
                return false;
            }
        }
        return true;
    }
}