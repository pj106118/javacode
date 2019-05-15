package jing;

import java.util.Scanner;

/**
 * @author: panjing
 * @describe:
 * @date: 2019/5/14
 * @time: 18:14
 */

public class DesignTriangle {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        Triangle triangle=new Triangle();
        System.out.println("请输入三角形的三边:");
        double side1 = input.nextDouble();
        double side2 = input.nextDouble();
        double side3 = input.nextDouble();
        triangle = new Triangle(side1,side2,side3);
        System.out.println("请输入三角形的颜色:");
        input.nextLine();
        String color=input.nextLine();
        System.out.println("请输入是否填充( true or false ):");
        boolean filled=input.nextBoolean();
        triangle.setColor(color);
        triangle.setFilled(filled);
        System.out.println("三角形面积为:"+triangle.getArea());
        System.out.println("三角形周长为:"+triangle.getPerimeter());
        System.out.println("三角形颜色为:"+triangle.getColor());
        System.out.println("三角形是否填充:"+filled);
    }
}
class GeometricObject {
    private String color = "white";
    private boolean filled;
    private java.util.Date dateCreated;

    public GeometricObject() {
        dateCreated = new java.util.Date();
    }
    public GeometricObject(String color, boolean filled) {
        this.dateCreated = new java.util.Date();
        this.color = color;
        this.filled = filled;
    }
    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return this.filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public java.util.Date getDateCreated() {
        return this.dateCreated;
    }

    public String toString() {
        return "created on" + this.dateCreated + "\n color: " +
                this.color + "and filled: " + this.filled;
    }
}
class Triangle extends GeometricObject{
    private double side1 = 1.0;
    private double side2 = 1.0;
    private double side3 = 1.0;
    public Triangle(){ }
    public Triangle(double side1,double side2,double side3){
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }
    public double getSide1(){
        return this.side1;
    }
    public double getSide2() {
        return this.side2;
    }
    public double getSide3() {
        return this.side3;
    }
    public double getArea(){      //返回三角形面积
        double result;
        double s=(side1+side2+side3)/2;
        result=Math.sqrt(s*(s-side1)*(s-side2)*(s-side3));
        return result;
    }
    public double getPerimeter(){    //返回三角形周长
        double perimeter = this.side1+this.side2+this.side3;
        return perimeter;
    }
    public String toString(){
        return "Triangle: side1 = "+ this.side1 +
                "side2 = "+ this.side2 + "side3" + this.side3;
    }

}