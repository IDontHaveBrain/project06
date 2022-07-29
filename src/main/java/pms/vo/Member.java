package pms.vo;

import java.util.Date;

public class Member {
	private String email;
	private String password;
	private String name;
	private String auth;
	private Date accessdate;
	public Member() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Member(String email, String password, String name, String auth, Date accessdate) {
		super();
		this.email = email;
		this.password = password;
		this.name = name;
		this.auth = auth;
		this.accessdate = accessdate;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public String getAuth() {
		return auth;
	}
	public void setAuth(String auth) {
		this.auth = auth;
	}
	public Date getAccessdate() {
		return accessdate;
	}
	public void setAccessdate(Date accessdate) {
		this.accessdate = accessdate;
	}
}
