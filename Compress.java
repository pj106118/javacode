/*
给定一组字符，使用原地算法将其压缩。

压缩后的长度必须始终小于或等于原数组长度。

数组的每个元素应该是长度为1 的字符（不是 int 整数类型）。

在完成原地修改输入数组后，返回数组的新长度。
*/
class Compress {
    public int compress(char[] chars) {
    	int s=0;
    	int e=0;
    	for(int i=0;i<chars.length;i++) {
    		if(i==chars.length-1 || chars[i+1]!=chars[i] ) {
    			
    			chars[e]=chars[s];
    			e++;
    			if(i>s) {
					
    				for(char c:((i-s+1)+"").toCharArray()) {
    					chars[e]=c;
    					e++;
    				}
    			}
    			s=i+1;
    		}
    	}
    	return e;
    }
}