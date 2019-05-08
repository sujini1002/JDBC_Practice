package driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyDriverTest {
	public static void main(String[] args) {
		Connection conn = null;
		//1. jdbc 드라이버(MariaDB) 로딩
		try {
			//1. class를 로딩한다.
			Class.forName("driver.MyDriver");
			
			//2.연결하기
			String url = "jdbc:mydb://192.168.1.37:3307/webdb";
			conn = DriverManager.getConnection(url,"webdb","webdb"); //dricerManager가 등록시켜 놓은 드라이버를 호출한다.
			System.out.println("연결성공:"+conn);
		}catch (ClassNotFoundException e) {
			System.out.println("DriverLoading 실패 : "+ e);
		} catch (SQLException e) {
			System.out.println("errr="+e);
		} finally {
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
	
}
