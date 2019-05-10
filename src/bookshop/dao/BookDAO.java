package bookshop.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookshop.vo.BookVO;

public class BookDAO {
	
	public List<BookVO> get(BookVO vo) {
		//검색
		return null;
	}
	public BookVO get(long no) {
		//검색
		return null;
	}
	public Boolean update(BookVO vo) {
		//책정보 변경
		return false;
	}
	//오버로딩
	public Boolean update(Long no,String status) {
		Boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnetction();
			
			String sql = "update book set status =? where no =?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, status);
			pstmt.setLong(2, no);
			
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
	public boolean insert(BookVO vo) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnetction();
			
			String sql = "insert into book values(null,?,'대여가능',?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setLong(2, vo.getAuthorNo());
			
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
	public List<BookVO> getList() {
		
		List<BookVO> result = new ArrayList<BookVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnetction();
			
			String sql = "select a.title,b.name,a.status from book a, author b where a.author_no = b.no order by a.no";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();//pstmt 내부에 있으므로 sql문장을 넣어줄 필요 없다.

			while(rs.next()) {
				String title = rs.getString(1);
				String name = rs.getString(2);
				String status = rs.getString(3);
				
				BookVO vo = new BookVO();
				vo.setTitle(title);
				vo.setAuthorName(name);
				vo.setStatus(status);
				
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
