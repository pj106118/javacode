/*
给定一个字符串 S，返回 “反转后的” 字符串，
其中不是字母的字符都保留在原地，而所有字母的位置发生反转。
*/
class  InvertLetters {
    public String reverseOnlyLetters(String S) {
        char[] a = S.toCharArray();
        int i =0;
        int j=a.length-1;
        while(i<j){
            if(a[i]>='A'&&a[i]<='Z'||a[i]>='a'&&a[i]<='z'){
                if(a[j]>='A'&&a[j]<='Z'||a[j]>='a'&&a[j]<='z'){
                    swap(a,i,j);
                    i++;
                    j--;
                }else{
                    j--;
                }
            }else{
                i++;
            }
        }
        return new String(a);
    }
    public void swap(char[] a,int i,int j){
        char tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}