package bookshop.main;

import java.util.List;
import java.util.Scanner;

import bookshop.dao.BookDAO;
import bookshop.vo.BookVO;

public class MainApp {

	public static void main(String[] args) {
		
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("대여 하고 싶은 책의 번호를 입력하세요:");
		Long num = scanner.nextLong();
		scanner.close();
		
		rent(num);
	
		displayBookInfo();
	}
	private static void rent(Long bookNo) {
		new BookDAO().update(bookNo, "대여중");
	}
	private static void displayBookInfo() {
		System.out.println("****************도서정보 출력*********************");
		List<BookVO> list = new BookDAO().getList();
		for(BookVO vo : list) {
			System.out.println("책 제목: "+ vo.getTitle() + ", 작가:"+vo.getAuthorName()+", 대여유무 :"+vo.getStatus());
		}
	}	
}