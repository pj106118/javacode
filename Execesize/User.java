package jing.able.OJ.Execesize;

/**
 * @author : panjing
 * @data : 2019/10/24 21:24
 * @describe :
 */
public class User {
    String name;
    String mobilePhone;
    String officePhone;

    public User(String name, String mobilePhone, String officePhone) {
        this.name = name;
        this.mobilePhone = mobilePhone;
        this.officePhone = officePhone;
    }

    @Override
    public String toString() {
        return "用户名为" + name  +
                ", mobilePhone= '" + mobilePhone +" \'"+
                ", officePhone= '" + officePhone +" \'";
    }
}
