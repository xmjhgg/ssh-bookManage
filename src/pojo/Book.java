package pojo;

public class Book {
	private int bid;
	private String bname;
	private String classify;
	private String date;
	private User user;
	public Book(){
		
	}
	
	

	public Book(String bname,String classify) {
		super();
		this.bname = bname;
		this.classify=classify;
	}



	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}
	
	public int getBid() {
		return bid;
	}



	public void setBid(int bid) {
		this.bid = bid;
	}



	public String getClassify() {
		return classify;
	}



	public void setClassify(String classify) {
		this.classify = classify;
	}

	

	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}
	


	public String getDate() {
		return date;
	}



	public void setDate(String date) {
		this.date = date;
	}



	@Override
	public String toString() {
		return "Book [bid=" + bid + ", bname=" + bname + ", classify="
				+ "classify]";
	}
	
}
