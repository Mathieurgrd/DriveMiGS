package drivemigs.bean.com;

import java.util.List;

public class TransportBean {
	
	public static final int transportIdle = 0;
	public static final int transportStarted = 10;
	public static final int transportEnded = 20;
	
	private UserBean transportDriver;
	private List<UserBean> transportPassenger;
	private int statutTransport; 

	
	
	public TransportBean(UserBean transportDriver, List<UserBean> transportPassenger) {
		super();
		this.transportDriver = transportDriver;
		this.setTransportPassenger(transportPassenger);
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
	
	
	

}
