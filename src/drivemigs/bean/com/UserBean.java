package drivemigs.bean.com;

public class UserBean {
	
	public static final int userDriver = 0 ;
	public static final int userHitchiker = 1 ;
	
	private String userName; 
	private String password;
	private int statutUser; 
	
	
	
	
	
	public UserBean(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public int getStatutUser() {
		return statutUser;
	}

	public void setStatutUser(int statutUser) {
		this.statutUser = statutUser;
	} 
	

}
