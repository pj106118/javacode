
//写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
public class AddNumber2 {
    public int Add(int num1,int num2) {
        return num2==0? num1:Add(num1^num2,(num1&num2)<<1);
    }
}