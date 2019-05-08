package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectTest {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		//1. jdbc 드라이버(MariaDB) 로딩
		try {
			//1.4 org.mariadb.jdbc.Driver 등의 드라이버의 이름을 기억해야한다.
			Class.forName("org.mariadb.jdbc.Driver");
			
			//2.연결하기
			String url = "jdbc:mariadb://192.168.1.37:3307/webdb";
			conn = DriverManager.getConnection(url,"webdb","webdb");
			
			//3.statement 객체 생성
			stmt = conn.createStatement();
			
			//4.SQL문 실행
			String sql = "select no, name from department";
			rs = stmt.executeQuery(sql);

			//5. 결과 가져오기
			while(rs.next()) {
				long no = rs.getLong(1);
				String name = rs.getString(2);
				
				System.out.println(no + ":"+name);
			}
		} catch (ClassNotFoundException e) {
			System.out.println("DriverLoading 실패 : "+ e);
		} catch(SQLException e) {
			System.out.println("errr="+e);
		}finally {
				try {
					if(rs!=null) {
						rs.close();
					}
					if(stmt != null) {
						stmt.close();
					}
					if(conn!=null) {
					conn.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			
		}
	}

}
