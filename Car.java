public class Car{

     //属性
     //发动机编号
     private String engineNumber;

     //品牌
     private String brand;

     //颜色
     private String color;
     
     //true 自动挡  false 手动挡
     private boolean autoType;
     
     //构造方法 
     //方法的参数名：符合标识符命名规范  简明思议
     public Car(String engineNumber){
         this.engineNumber = engineNumber;
     }
     
     //getter setter
     //现阶段就这么写，自动生成
     //this 该类实例化的对象，即当前操作的对象
     public String getEngineNumber(){
         return this.engineNumber;
     }
     
     public String getBrand(){
         return this.brand;
     }
     
     public void setBrand(String brand){
         this.brand = brand;
     }
     
     public String getColor(){
         return this.color;
     }
     
     public void setColor(String color){
         this.color = color;
     }

     //属性是boolean类型的getter方法 => isXxx
     public boolean isAutoType(){
         return this.autoType;
     }
     
     public void setAutoType(boolean autoType){
         this.autoType = autoType;
     }
     
     public String getCarDescription(){
         return "发动机编号:"+this.getEngineNumber() +"\n"
         + "品牌："+this.brand+"\n"
         + "颜色："+this.color+"\n"
         + "是否自动挡："+this.isAutoType();
     }
     
     //行为（功能）
     public void drive(){
         System.out.println("向前开 喝酒不开车，开车不喝酒");
         //结合方法使用
         if(this.isAutoType()){
             System.out.println("自动挡，好开");
         }else{
             System.out.println("手动挡，手疼");
         }
     }
     
     public void back(){
         System.out.println("倒车 请注意");
     }
     
     
     
     public static void main(String[] args){
         /*
         Car  wlhg = new Car("WL0010");
         wlhg.drive();
         wlhg.setAutoType(true);
         wlhg.drive();
         wlhg.setColor("白色");
         wlhg.setBrand("五菱宏光");
         
         String desc = wlhg.getCarDescription();
         System.out.println(desc);
         */
         
         //数组
         //1.静态初始化
         //2.动态初始化
         Car[] cars = new Car[]{
                new Car("WL00110"),
                new Car("HX00111"),
         };
         //赋值操作
         cars[0].setBrand("");
         
         
     }


}