package entity;

public class Coordinate {
	/*
	 * ��ַ��Ӧ�ľ�γ��
	 */
	private Address address;    //��ַ
	
	private double lat;         //γ��
	
	private double lng;         //����
	
	private String platform;      //���õ�API
	
	private String coordinateSystem;  //��������ϵ
	
	/*
	 * get����
	 */
	public Address getAddress() {
		return address;
	}
	
	public double getlat() {
		return lat;
	}
	
	public double getlng() {
		return lng;
	}
	
	public String getPlatform() {
		return platform;
	}
	
	public String getCoordinateSystem() {
		return coordinateSystem;
	}
	
	/*
	 * set����
	 */
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public void setLat(double lat) {
		this.lat = lat;
	}
	
	public void setlng(double lng) {
		this.lng = lng;
	}
	
	public void setPlatForm(String platform) {
		this.platform = platform;
	}
	
	public void setCoordinateSystem(String coordinateSystem) {
		this.coordinateSystem = coordinateSystem;
	}
}
