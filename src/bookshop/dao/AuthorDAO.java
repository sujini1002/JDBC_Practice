package bookshop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bookshop.vo.AuthorVO;

public class AuthorDAO {
	public boolean insert(AuthorVO vo) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnetction();
			
			String sql = "insert into author values(null,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			
			int cnt = pstmt.executeUpdate();
			result = cnt==1?true:false;
			
		}catch(SQLException e) {
			System.out.println("errr="+e);
		}finally {
				try {
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
	}
	public List<AuthorVO> getList() {
		
		List<AuthorVO> result = new ArrayList<AuthorVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnetction();
			
			String sql = "select no, name from author";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();//pstmt 내부에 있으므로 sql문장을 넣어줄 필요 없다.

			while(rs.next()) {
				long no = rs.getLong(1);
				String name = rs.getString(2);
				
				AuthorVO vo = new AuthorVO();
				vo.setNo(no);
				vo.setName(name);
				
				result.add(vo);
			}
		}catch(SQLException e) {
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
	}
	private Connection getConnetction() throws SQLException {
		
		Connection conn = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://192.168.1.37:3307/webdb";
			conn = DriverManager.getConnection(url,"webdb","webdb");
			
		} catch (ClassNotFoundException e) {
			System.out.println("DriverLoading 실패 : "+ e);
		} 
		
		
		return conn;
	}
}
