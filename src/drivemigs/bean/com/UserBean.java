package drivemigs.bean.com;

public class UserBean {
	
	public static final int userDriver = 0 ;
	public static final int userHitchiker = 1 ;
	
	private String userName; 
	private String password;
	private String firstName;
	private String name;
	private String emailAdress;
	private String location;
	private int statutUser; 
	

	public UserBean() {
		super();
	}
	public UserBean(String userName, String password, String name, String firstName,String emailAdress,String location ) {
		this.userName = userName;
		this.password = password;
		this.name= name;
		this.firstName = firstName;
		this.password = password;
		this.emailAdress = emailAdress;
		this.location = location;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
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

	public String getEmailAdress() {
		return emailAdress;
	}

	public void setEmailAdress(String emailAdress) {
		this.emailAdress = emailAdress;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	} 
	
	

}
