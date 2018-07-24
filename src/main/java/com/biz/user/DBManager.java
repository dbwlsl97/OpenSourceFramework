package com.biz.user;
import java.sql.*;

public class DBManager {
	public Connection dbConn() {		
		Connection conn = null;
		String url = "jdbc:oracle:thin:@127.00.0.1:1521:XE";
		try {
			conn = DriverManager.getConnection(url, "ssu", "0000");
			if(conn != null)
				System.out.println("연결성공");
			else
				System.out.println("연결실패");
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	//selcet용
	public void dbClose(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		try {
			if(rs != null)	rs.close();
			if(pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//insert, update, delete용
	public void dbClose(PreparedStatement pstmt, Connection conn) {
		try {
			if(pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
