package drivemigs.bean.com;

import java.util.Date;
import java.util.List;

public class TrajetBean {
	
	public static final int transportFermer = 0;
	public static final int transportOuvert = 10;
	public static final int transportStarted = 20;
	public static final int transportEnded = 30;
	
	private UserBean transportDriver;
	private List<UserBean> transportPassenger;
	private int statutTransport; 
	private double LatDepart;
	private double LongDepart;
	private Date dateDepart;
	private String heureDepart;
	private String address;

	
	

	
	public TrajetBean(UserBean user, Date date, String address, String hour) {
		// TODO Auto-generated constructor stub
		this.transportDriver=user;
		this.dateDepart=date;
		this.heureDepart=hour;
		this.address=address;
	}

	public TrajetBean(UserBean user, String address, String hour) {
		// TODO Auto-generated constructor stub
		this.transportDriver=user;
		this.heureDepart=hour;
		this.address=address;
	}

	public UserBean getTransportDriver() {
		return transportDriver;
	}
	
	public void setTransportDriver(UserBean transportDriver) {
		this.transportDriver = transportDriver;
	}

	public List<UserBean> getTransportPassenger() {
		return transportPassenger;
	}

	public void setTransportPassenger(List<UserBean> transportPassenger) {
		this.transportPassenger = transportPassenger;
	}

	public int getStatutTransport() {
		return statutTransport;
	}

	public void setStatutTransport(int statutTransport) {
		this.statutTransport = statutTransport;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
	}

	public String getHeureDepart() {
		return heureDepart;
	}

	public void setHeureDepart(String heureDepart) {
		this.heureDepart = heureDepart;
	} 
	
	
	

}
