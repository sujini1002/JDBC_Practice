package hr;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoPrepare {

	public List<EmployeeVo> getList(String keyword){
		List<EmployeeVo> result = new ArrayList<EmployeeVo>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//1. jdbc 드라이버(MariaDB) 로딩
		try {
			//1.4 org.mariadb.jdbc.Driver 등의 드라이버의 이름을 기억해야한다.
			Class.forName("org.mariadb.jdbc.Driver");
			
			//2.연결하기
			String url = "jdbc:mariadb://192.168.1.37:3307/employees";
			conn = DriverManager.getConnection(url,"hr","hr");
			
			//3.SQL준비
			String sql = "select emp_no,first_name,last_name,hire_date from employees where first_name like ? or last_name like ?";
			pstmt=conn.prepareStatement(sql);
			
			//4.바인딩
			pstmt.setString(1, "%"+keyword+"%");
			pstmt.setString(2, "%"+keyword+"%");
			
			//5.SQL 실행
			rs = pstmt.executeQuery();

			//5. 결과 가져오기
			while(rs.next()) {
				long no = rs.getLong(1);
				String first_name = rs.getString(2);
				String last_name = rs.getString(3);
				String hire_date = rs.getString(4);
				
				EmployeeVo vo = new EmployeeVo();
				vo.setNo(no);
				vo.setFirst_name(first_name);
				vo.setLast_name(last_name);
				vo.setHire_date(hire_date);
				//list에 저장
				result.add(vo);
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
					if(pstmt != null) {
						pstmt.close();
					}
					if(conn!=null) {
					conn.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			
		}
		return result;
	}//end getList()
}
