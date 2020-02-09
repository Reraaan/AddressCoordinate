package entity;

public class Coordinate {
	/*
	 * 地址对应的经纬度
	 */
	private Address address;    //地址
	
	private double lat;         //纬度
	
	private double lng;         //经度
	
	private String platform;      //调用的API
	
	private String coordinateSystem;  //所用坐标系
	
	/*
	 * get方法
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
	 * set方法
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
