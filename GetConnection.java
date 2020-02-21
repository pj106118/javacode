public class GetConnection{
    public  Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            Connection connection = DriverManager.getConnection(
										"jdbc:mysql://localhost:3306/java_image_server"
										,"root","123");
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}