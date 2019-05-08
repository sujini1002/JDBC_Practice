package hr;

public class EmployeeVo {
	private long no;
	private String birth_date;
	private String first_name;
	private String last_name;
	private String gender;
	private String hire_date;
	
	public long getNo() {
		return no;
	}
	public void setNo(long no) {
		this.no = no;
	}
	public String getBirth_date() {
		return birth_date;
	}
	public void setBirth_date(String birth_date) {
		this.birth_date = birth_date;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getHire_date() {
		return hire_date;
	}
	public void setHire_date(String hire_date) {
		this.hire_date = hire_date;
	}
	
	@Override
	public String toString() {
		return "EmployeeVo [no=" + no + ", birth_date=" + birth_date + ", first_name=" + first_name + ", last_name="
				+ last_name + ", gender=" + gender + ", hire_date=" + hire_date + "]";
	}
	
}
