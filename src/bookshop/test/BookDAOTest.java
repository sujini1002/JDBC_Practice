package bookshop.test;

import java.util.List;

import bookshop.dao.BookDAO;
import bookshop.vo.BookVO;

public class BookDAOTest {
	public static void main(String[] args) {
//		insert("아리랑",2L);
//		insert("젊은그들",3L);
//		insert("아프니깐 청춘이다",4L);
//		insert("귀천",5L);
//		insert("태백산맥",6L);
//		insert("풀하우스",6L);
		getListTest();
	}
	public static void insert(String title,long authorNo) {
		BookVO vo = new BookVO();
		vo.setTitle(title);
		vo.setAuthorNo(authorNo);
		
		new BookDAO().insert(vo);
	}
	public static void getListTest() {
		List<BookVO> list = new BookDAO().getList();
		for(BookVO vo : list) {
			System.out.println(vo);
		}
	}
}

