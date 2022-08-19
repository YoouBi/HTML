package user;

class User { // 개인정보
	private String id;
	private String pw;
	private String name;
	private int birthday; // 우리나라 최고령자 나이는 115세~
	private String callNum;
	
	public User(String id, String pw, String name, int birthday, String callNum) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.birthday = birthday;
		this.callNum = callNum;
	}

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getPw() {
		return pw;
	}
	
	public void setPw(String pw) {
		this.pw = pw;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getBirthday() {
		return birthday;
	}

	public void setBirthday(int birthday) {
		this.birthday = birthday;
	}
	
	public String getCallNum() {
		return callNum;
	}
	
	public void setCallNum(String callNum) {
		this.callNum = callNum;
	}
}