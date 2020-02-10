/*
将字符串转换成整数
*/
class StringConversionDigit {
    public int myAtoi(String str) {  
        // 判空、去掉空格
        if (str == null || (str = str.trim()).equals("")) {
            return 0;
        }
        int index = 0;
		int flag =1;
        // 符号位
        if (str.charAt(index) == '-') {
            index++;
            flag = -1;
        } else if (str.charAt(index) == '+') {
            index++;
        }
        // 最终结果
        long sum = 0;
        while (index < str.length() && str.charAt(index) >= '0' && str.charAt(index) <= '9') {
            sum = sum * 10 + flag * (str.charAt(index) - '0');
            // 越界判断
            if (sum < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            } else if (sum > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            index++;
        }
        return (int) sum;
    }
}
