package pojo;

import java.util.HashSet;
import java.util.Set;

public class User {
	private int sid;
	private String username;
	private String password;
	private String password2;
	private String name;
	private String phone;
	private Set<Book> books=new HashSet<Book>();
	
	public User(){
		
	}
	
	
	protected User(String username, String password, String name, String phone) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.phone = phone;
	}


	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	
	public Set<Book> getBooks() {
		return books;
	}


	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	
	public String getPassword2() {
		return password2;
	}


	public void setPassword2(String password2) {
		this.password2 = password2;
	}


	@Override
	public String toString() {
		return "User [id=" + sid + ", username=" + username + ", password="
				+ password + ", name=" + name + ", phone=" + phone + "]";
	}
	
	
}
