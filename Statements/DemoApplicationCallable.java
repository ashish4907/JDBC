import java.sql.*;

public class DemoApplicationCallable {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db", "root", "root");

		Statement st = conn.createStatement();
//		CallableStatement cs = conn.prepareCall("{call sp_readStudentData(?)}");
//		CallableStatement cs = conn.prepareCall("{call sp_createStudentData(?,?,?,?)}");
		CallableStatement cs = conn.prepareCall("{call sp_crudOperation(?,?,?,?,?,?,?)}");

		// Insert the data		
		cs.setInt(1, 8);
		cs.setString(2, "Sony");
		cs.setString(3, "B.tech");
		cs.setString(4, "2010-01-20");

		// update the data
		cs.setInt(5,3);
		cs.setString(7, "Ashish");

		// Delete the data

		cs.setInt(6, 4);
	
//		cs.execute();

		ResultSet rs = cs.executeQuery();
		while (rs.next()) {

			System.out.println(rs.getString(1) + "," + rs.getString(2) + "," + rs.getString(3) + "," + rs.getString(4));
		}

	}
}
