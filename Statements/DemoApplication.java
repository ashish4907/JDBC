import java.sql.*;

public class DemoApplication {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db", "root", "root");

		Statement st = conn.createStatement();
//		String sql= "INSERT INTO `student_db`.`student` (`id`, `name`, `dept`) VALUES ('1', 'John', 'EC')"
//		st.executeUpdate(sql);
//		String sql = "UPDATE student set name="doe" where id=2 ";
//		st.executeUpdate(sql);

//		String sql = "delete from student where id=4";
//		st.executeUpdate(sql);
//		
//		String sql = "alter table student add DOJ date";
//		st.executeUpdate(sql);
		
		
		ResultSet rs = st.executeQuery("select * from student");

		while (rs.next()) {
			String id = rs.getString("id");
			String name = rs.getString("name");
			String dept = rs.getString("dept");

			System.out.println("id-- " + id + " " + "name-- " + name + " " + "dept-- " + dept);
		}

		st.close();
		conn.close();

	}

}
