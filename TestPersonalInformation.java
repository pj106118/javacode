public class TestPersonalInformation{
    
    public static void main(String[] args){
        
        PersonalInformation p = new PersonalInformation("Mary",false);;
        
        p.setPost("HR Director");
        p.setTel("18081318888");
        p.setAge(26);
        p.setAddress("DaTun road nno. 6, ChaoYang, Beijing");
        
        p.printPersonalInformation();
    }
    
}
class PersonalInformation{
   private final String name;
   private final boolean gender;
   private String tel;
   private String post;
   private int age;
   private String address;
   
   public PersonalInformation(String name, boolean gender){
       this.name = name;
       this.gender = gender;
   }
   public void setTel(String tel){
       this.tel = tel;
   }
   public void setPost(String post){
       this.post =post;
   }
   public void setAge(int age){
       this.age= age;
   }
   public void setAddress(String address){
       this.address = address;
   }
   
   public String getTel(){
       return this.tel;
   }
   public String getPost(){
       return this.post;
   }
   public int getAge(){
       return this.age;
   }
   public String getName(){
       return this.name;
   }
   public boolean isGender(){
       return this.gender;
   }
   public String getAddress(){
       return this.address;
   }
   
   public void printPersonalInformation(){
      System.out.println("Name:"+this.name+ "  Post:" + this.post);
      System.out.println("Sex:"+ (this.gender? "female":"male") +"  Age:" + this.age);
      System.out.println("Tel:"+this.tel + "  Address:" + this.address); 
   }
}
