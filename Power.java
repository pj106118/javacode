//给定一个double类型的浮点数base和int类型的整数exponent,
//求base的exponent次方。保证base和exponent不同时为0.

public class Power{
 public double Power1(double base, int exponent) {
        if(base==0){
            return 0;
        }
        if(exponent==0){
            return 1;
        }
        if(exponent > 0){
       double a=1;
        int i = 1;
        while(i <= exponent){
            a *= base; 
            i++;
        }
        return a;
        }else{
        double b=1;
        int i = -1;
        while(i >= exponent){
            b *= base; 
            i--;
        }
        return 1/b;
        }
  }
  //这是对上面的进行一个优化的方法
  public double Power2(double base, int exponent) {
        if(base==0){
            return 0;
        }
        if(exponent==0){
            return 1;
        }
       double a=1;
        int i = 1;
        int e = exponent > 0 ? exponent : -exponent;
        while(i <= e){
            a *= base; 
            i++;
        }
        
        return exponent > 0 ? a : 1/a;
  }
}