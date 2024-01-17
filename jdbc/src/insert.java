import java.sql.*;

public class insert {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "Navya@2002");

            Statement st = con.createStatement();

            // st.execute("create table Company2(eid int(100),ename char(200),esalary
            // int(200))");

            String q = "insert into Company2 values(1,'navya',15000)";

            String q1 = "insert into Company2 values(2,'palla',25000)";
            String q2 = "insert into Company2 values(3,'sri',16000)";
            String q3 = "insert into Company2 values(4,'anna',17000)";
            st.addBatch(q);
            st.addBatch(q1);
            st.addBatch(q2);
            st.addBatch(q3);

            st.executeBatch();

            ResultSet rs = st.executeQuery("select*from company2");
            ResultSetMetaData rm = rs.getMetaData();
            for (int i = 1; i < 4; i++) {
                System.out.println(rm.getColumnName(i));
            }

            while (rs.next()) {
                System.out.println(rs.getInt(1));
                System.out.println(rs.getString(2));
                System.out.println(rs.getInt(3));
            }
            System.out.println("done");

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}