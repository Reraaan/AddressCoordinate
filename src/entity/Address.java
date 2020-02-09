package entity;

public class Address {
	/*
	 * 所需定位的地址
	 */
	private String address;    //地址字符串
	
	private String province;   //省份
	
	private String city;       //城市
	
	private String district;   //区县
	
	private String street;     //街道
	
	private String number;     //门牌号
	
	/*
	 * get方法
	 */
	public String getAddress() {
		return address;
	}
	
	public String getProvince() {
		return province;
	}
	
	public String getCity() {
		return city;
	}
	
	public String getdiStrict() {
		return district;
	}
	
	public String getStreet() {
		return street;
	}
	
	public String getNumber() {
		return number;
	}
	
	/*
	 * set方法
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setProvince(String province) {
		this.province = province;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public void setDistrict(String district) {
		this.district = district;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
	
	public void setNumber(String number) {
		this.number = number;
	}
}
