package bookshop.test;

import java.util.List;

import bookshop.dao.AuthorDAO;
import bookshop.vo.AuthorVO;

public class AuthorDAOTest {
	public static void main(String[] args) {
		//getList Test
//		insertTest("김동인");
//		insertTest("김난도");
//		insertTest("천상병");
//		insertTest("원수연");
		getListTest();
		
	}
	public static void getListTest() {
		
		AuthorDAO dao = new AuthorDAO();
		List<AuthorVO> list = dao.getList();
		
		for(AuthorVO vo : list) {
			System.out.println(vo);
		}
	}
	public static void insertTest(String name) {
		AuthorVO vo = new AuthorVO();
		vo.setName(name);
		
		new AuthorDAO().insert(vo);
	}
}
