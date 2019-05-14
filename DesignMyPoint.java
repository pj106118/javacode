package jing.able;

/**
 * @author: panjing
 * @describe:
 * @date: 2019/5/10
 * @time: 13:38
 */

public class DesignMyPoint {
    public static void main(String[] args) {
        MyPoint point1 = new MyPoint();
        MyPoint point2 = new MyPoint(10,30.5);
        double distance = point1.distance(point2);
        System.out.println(distance);
    }
}
class MyPoint{
    private double x;
    private double y;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public MyPoint(){
        this.x = 0;
        this.y = 0;
    }

    public MyPoint(double x,double y){
        this.x = x;
        this.y = y;
    }

    public double distance(MyPoint p1,MyPoint p2){
       // Math.hypot() 函数返回它的所有参数的平方和的平方根
        double distance = Math.hypot((p1.getX()-p2.getX()),(p1.getY()-p2.getY()));
        return distance;
    }

    public double distance(MyPoint p){
        double distance = Math.hypot((x-p.getX()),(y-p.getY()));
        return distance;
    }

}