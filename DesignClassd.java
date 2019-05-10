package jing.able;
import java.util.Date;

/**
 * @author: panjing
 * @describe:   设计一个类
 * @date: 2019/5/9
 * @time: 17:53
 */

public class DesignClassd {
    public static void main(String[] args) {
        Account account = new Account(1122,20000);
        account.setAnnualInterestRate(0.045);
        account.withDraw(2500);
        account.deposit(3000);
        account.getAccountInfor();
    }
}
class Account{
    private int id;
    private double balance;  //初始余额
    private double annualInterestRate;   //存储年利率
    private Date dateCreated; //存储账户的开户日期

    public Account(){} //构建Account的无参构造方法

    public Account(int id,double balance){
        this.id = id;
        this.balance = balance;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAnnualInterestRate() {
        return this.annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public Date getDateCreated() {
        return this.dateCreated;
    }

    //返回月利息
    public double getMonthlyInterestRate(){
        return (this.annualInterestRate/12) * this.balance;
    }

    //从账户提取特定数额
    public  double withDraw(double money){
        this.balance = balance - money;
        return this.balance;
    }
    //从账户存取特定数额
    public double deposit(double money){
        this.balance = balance + money;
        return this.balance;
    }

    public void getAccountInfor(){
        System.out.println("余额为" + this.balance +"美元"+ "\n" +
                "月利息为" + getMonthlyInterestRate()+"\n"+
                "开户日期为"+getDateCreated());
    }
}
