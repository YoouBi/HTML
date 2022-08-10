package hello;

public class persons {
	private String firstname;
	private String lastname;
	private int age;
	private String email;
	
	public persons() {
		super();
	}
	
	public persons(String firstname, String lastname, int age, String email) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
		this.email = email;
	}
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "persons [name=" + lastname + firstname + ", age=" + age + ", email=" + email + "]";
	}
	
}
