//判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
class Huiwen {
    public boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        char[] s = str.toCharArray();
        for(int i = 0;i<s.length/2;i++){
            if(s[i] != s[s.length-1-i]){
                return false;
            }
        }
        return true;
    }
}