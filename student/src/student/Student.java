package student;

public class Student {
	private int no;
	private String name;
	private int grade;
	private String addr;
	private String birthday;
	
	public Student() {
		super();
	}
	public Student(int no, String name, int grade, String addr, String birthday) {
		super();
		this.no = no;
		this.name = name;
		this.grade = grade;
		this.addr = addr;
		this.birthday = birthday;
	}


	public int getNo() {
		return no;
	}


	public void setNo(int no) {
		this.no = no;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getGrade() {
		return grade;
	}


	public void setGrade(int grade) {
		this.grade = grade;
	}


	public String getAddr() {
		return addr;
	}


	public void setAddr(String addr) {
		this.addr = addr;
	}


	public String getBirthday() {
		return birthday;
	}


	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}


	@Override
	public String toString() {
		return "Student [no=" + no + ", name=" + name + ", grade=" + grade + ", addr=" + addr + ", birthday=" + birthday
				+ "]";
	}
	

}
