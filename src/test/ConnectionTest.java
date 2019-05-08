package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {

	public static void main(String[] args) {
		Connection conn = null;
		//1. jdbc 드라이버(MariaDB) 로딩
		try {
			//1.4org.mariadb.jdbc.Driver 등의 드라이버의 이름을 기억해야한다.
			Class.forName("org.mariadb.jdbc.Driver");
			//2.연결하기
			String url = "jdbc:mariadb://192.168.1.37:3307/webdb";
			conn = DriverManager.getConnection(url,"webdb","webdb");
			System.out.println("연결성공");
		} catch (ClassNotFoundException e) {
			System.out.println("DriverLoading 실패 : "+ e);
		} catch(SQLException e) {
			System.out.println("errr="+e);
		}finally {
				try {
					if(conn!=null) {
					conn.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			
		}
		
	}

}//주석
