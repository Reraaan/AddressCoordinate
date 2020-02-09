package sevice;

import entity.Address;
import entity.Coordinate;
import net.sf.json.JSONObject;

public class ParseJson {
	
	/*
	 * @description 解析百度API返回结果JSON
	 * @param String API调用返回结果
	 * @return Coordinate 经纬度
	 */
	public Coordinate ParseFromBaidu(Address address, String response) {
		
		if(response != null && !response.equals("")) {
			Coordinate coordinate = new Coordinate();
			JSONObject json = JSONObject.fromObject(response);
			if(json.getString("status").equals("0")) {
				double lng = json.getJSONObject("result").getJSONObject("location").getDouble("lng");
				double lat = json.getJSONObject("result").getJSONObject("location").getDouble("lat");
				coordinate.setAddress(address);
				coordinate.setLat(lat);
				coordinate.setlng(lng);
				coordinate.setPlatForm("baidu");
				coordinate.setCoordinateSystem("BD-09");
				return coordinate;
			}
		}
		
		return null;
	}
	
	/*
	 * @description 解析高德API返回结果JSON
	 * @param String API调用返回结果
	 * @return Coordinate 经纬度
	 */
	public Coordinate ParseFromGaode(Address addr, String response) {
		
		if(response != null && !response.equals("")) {
			Coordinate coordinate = new Coordinate();
			JSONObject json = JSONObject.fromObject(response);
			if(json.getString("status").equals("1") && json.getString("info").equals("OK")) {
				if(json.getJSONArray("geocodes").size() > 0) {
					String location = json.getJSONArray("geocodes").getJSONObject(0).getString("location");
					Double lng = Double.parseDouble(location.split(",")[0]);
					Double lat = Double.parseDouble(location.split(",")[1]);
					
					//地址信息结构化
					Address address = new Address();
					address.setAddress(json.getJSONArray("geocodes").getJSONObject(0).getString("formatted_address"));
					address.setProvince(json.getJSONArray("geocodes").getJSONObject(0).getString("province"));
					address.setCity(json.getJSONArray("geocodes").getJSONObject(0).getString("city"));
					address.setDistrict(json.getJSONArray("geocodes").getJSONObject(0).getString("district"));
					address.setStreet(json.getJSONArray("geocodes").getJSONObject(0).getString("street"));
					address.setNumber(json.getJSONArray("geocodes").getJSONObject(0).getString("number"));
					
					coordinate.setAddress(address);
					coordinate.setLat(lat);
					coordinate.setlng(lng);
					coordinate.setPlatForm("gaode");
					coordinate.setCoordinateSystem("GCJ-02");
					return coordinate;
				}
			}
		}
		
		return null;
	}
	
	/*
	 * @description 解析腾讯API返回结果JSON
	 * @param String API调用返回结果
	 * @return Coordinate 经纬度
	 */
	public Coordinate ParseFromTecent(Address address, String response) {
		
		if(response != null && !response.equals("")) {
			Coordinate coordinate = new Coordinate();
			JSONObject json = JSONObject.fromObject(response);
			if(json.getString("status").equals("0")) {
				double lng = json.getJSONObject("result").getJSONObject("location").getDouble("lng");
				double lat = json.getJSONObject("result").getJSONObject("location").getDouble("lat");
				coordinate.setAddress(address);
				coordinate.setLat(lat);
				coordinate.setlng(lng);
				coordinate.setPlatForm("tecent");
				coordinate.setCoordinateSystem("GCJ-02");
				return coordinate;
			}
		}
		
		return null;
	}
}
