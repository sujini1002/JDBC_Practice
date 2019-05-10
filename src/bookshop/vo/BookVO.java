package bookshop.vo;

public class BookVO {
	private long no;
	private String title;
	private String status;
	
	//객체지향이 무시된 기법
	private long authorNo;
	private String authorName;
	//private AuthorVO authorVO; 객체지향이 사용되는 문법(ORM시 사용)-book테이블에서 author테이블의 no를 참조하고 있으므로
	
	public long getNo() {
		return no;
	}
	public void setNo(long no) {
		this.no = no;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public long getAuthorNo() {
		return authorNo;
	}
	public void setAuthorNo(long authorNo) {
		this.authorNo = authorNo;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	
	@Override
	public String toString() {
		return "BookVO [no=" + no + ", title=" + title + ", status=" + status + ", authorNo=" + authorNo
				+ ", authorName=" + authorName + "]";
	}
	
	
}
