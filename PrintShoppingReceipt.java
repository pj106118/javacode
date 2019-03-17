public class PrintShoppingReceipt{
	public static void main(String[] args){
		ShoppingReceipt p = new ShoppingReceipt(245);
		
		p.setSandShores(570);
		p.setTennisRacket(320);
		p.setShirtNum(2);
		p.setSandShoresNum(1);
		p.setTennisRacketNum(1);
		p.printPriseInformation();
	}
	
}
class ShoppingReceipt{
	private int shirt;
	private int sandShores;
	private int tennisRacket;
	
	private int shirtNum;
	private int sandShoresNum;
	private int tennisRacketNum;
	public ShoppingReceipt(int shirt){
       this.shirt = shirt;
   }
	public int getSandShores(){
		return sandShores;
	}
	public int getTennisRacket(){
		return tennisRacket;
	}
	public void setSandShores(int sandShores){
		this.sandShores = sandShores;
	}
	public void setTennisRacket(int tennisRacket){
		this.tennisRacket = tennisRacket;
	}
    
	
	public int getShirtNum(){
		return shirtNum;
	}
	public int getSandShoresNum(){
		return sandShoresNum;
	}
	public int getTennisRacketNum(){
		return tennisRacketNum;
	}
	public void setShirtNum(int shirtNum){
		this.shirtNum = shirtNum;
	}
	public void setSandShoresNum(int sandShoresNum){
		this.sandShoresNum = sandShoresNum;
	}
	public void setTennisRacketNum(int tennisRacketNum){
		this.tennisRacketNum = tennisRacketNum;
	}
    	
	int pay = 1500;	
	
	public void printPriseInformation(){
	    System.out.println("********** 消费单 **********");
		System.out.println("购买物品"+" 单价  "+"个数  "+"  金额");
		System.out.println("T恤  "+"\t"+ this.shirt +"\t"+ this.shirtNum +"\t" + this.shirt * this.shirtNum);
		System.out.println("网球鞋 "+"\t"+this.sandShores+"\t"+this.sandShoresNum+"\t"+this.sandShores*this.sandShoresNum);
	    System.out.println("网球拍 "+"\t"+this.tennisRacket+"\t"+this.tennisRacketNum+"\t"+this.tennisRacket*this.tennisRacketNum);
	    System.out.println();
		System.out.println("折扣： " + "\t" + "8折");
		System.out.println("消费总金额" +"\t"+ "￥"+((this.shirt*this.shirtNum+this.sandShores*this.sandShoresNum+this.tennisRacket*this.tennisRacketNum)*0.8));
		
		System.out.println("实际交费"+"\t"+"￥"+pay);
		System.out.println("找钱 "+" \t "+"￥"+(pay-((this.shirt*this.shirtNum+this.sandShores*this.sandShoresNum+this.tennisRacket*this.tennisRacketNum)*0.8)));
		
		
	}
}