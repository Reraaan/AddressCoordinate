package entity;

public class Address {
	/*
	 * ���趨λ�ĵ�ַ
	 */
	private String address;    //��ַ�ַ���
	
	private String province;   //ʡ��
	
	private String city;       //����
	
	private String district;   //����
	
	private String street;     //�ֵ�
	
	private String number;     //���ƺ�
	
	/*
	 * get����
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
	 * set����
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
