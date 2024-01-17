import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class update {
    public static void main(String[] args) {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "Navya@2002");

            Statement st = con.createStatement();
            st.executeUpdate("update company2 set esalary=50000 where eid=3");
            System.out.println("updated");
            st.executeUpdate("delete from company2 where eid=4");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
