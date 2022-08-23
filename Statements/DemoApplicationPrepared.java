import java.sql.*;

public class DemoApplicationPrepared {

	public static void main(String[] args) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db", "root", "root");

//		String query ="select * from student where name=? and id = ? and dept =? and DOJ=?";
		String query = "update student set name = ? where id =?";
		PreparedStatement ps = conn.prepareStatement(query);
//		PreparedStatement ps = conn.prepareStatement(query);

//		ps.setString(1, "John");
//		ps.setInt(2, 1);
//		ps.setString(3, "EC");
//		ps.setString(4, "2022-08-23");

		ps.setString(1, "John");
		ps.setInt(2, 1);
		int i = ps.executeUpdate();
//		ps.execute();
		System.out.println(i + " " + "Record updated");

		ResultSet rs = ps.executeQuery("select * from student");
		while (rs.next()) {
			
			System.out.println(rs.getString(1) + "," + rs.getString(2) + "," + rs.getString(3) + "," + rs.getString(4));
		}

		ps.close();
		conn.close();
	}
}
