package pojo;

public class Log {
	private Integer lid;
	private String username;
	private String bname;
	private String action;
	private String date;
	public Log(){
		
	};
	
	public Log(String username, String bname, String action, String date) {
		super();
		this.username = username;
		this.bname = bname;
		this.action = action;
		this.date = date;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Integer getLid() {
		return lid;
	}
	public void setLid(Integer lid) {
		this.lid = lid;
	}
	@Override
	public String toString() {
		return "Log [lid=" + lid + ", username=" + username + ", bname="
				+ bname + ", action=" + action + ", date=" + date + "]";
	}
	
	
}
