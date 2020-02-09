package sevice;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import entity.Address;
import entity.Coordinate;
import util.HttpClientUtil;

public class GetCoordinate {
	
	private HttpClientUtil httpClientUtil;
	
	private ParseJson parseJson;
	
	public GetCoordinate() {
		httpClientUtil = new HttpClientUtil();
		parseJson = new ParseJson();
	}
	
	/*
	 * @description 调用百度地图API获取指定地址的经纬度
	 * @param 
	 * @return Coordinate 经纬度
	 */
	public Coordinate getByBaidu(Address address) {
		//百度地图API
		String url = "http://api.map.baidu.com/geocoding/v3/";
		Map<String, String> params = new HashMap<String, String>();
		params.put("address", address.getAddress());
		params.put("output", "json");
		params.put("ak", "y199ysWi7k1PlriinPWIqMWf0S5U5NvR");

		//调用百度地图API
		String result = httpClientUtil.doGet(url, params);
		Coordinate coordinate = parseJson.ParseFromBaidu(address, result);
		return coordinate;
	}
	
	/*
	 * @description 调用高德地图API获取指定地址的经纬度
	 * @param 
	 * @return Coordinate 经纬度
	 */
	public Coordinate getByGaode(Address address) {
		//高德地图API
		String url = "https://restapi.amap.com/v3/geocode/geo";
		Map<String, String> params = new HashMap<String,  String>();
		String urlAddress = address.getAddress();
		try {
			urlAddress = URLEncoder.encode(urlAddress, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		params.put("address", urlAddress);
		params.put("output", "JSON");
		params.put("key", "f09b65f1d7d1f4f44da1ef2173ec0714	");
		
		//调用API获取经纬度
		String result = httpClientUtil.doGet(url, params);
		
		Coordinate coordinate = parseJson.ParseFromGaode(address, result);
		return coordinate;
	}
	
	/*
	 * @description 调用腾讯地图API获取指定地址的经纬度
	 * @param 
	 * @return Coordinate 经纬度
	 */
	public Coordinate getByTecent(Address address) {
		//腾讯地图API
		String url = "https://apis.map.qq.com/ws/geocoder/v1/";
		Map<String, String> params = new HashMap<String, String>();
		String urlAddress = address.getAddress();
		try {
			//中文地址进行utf8编码
			urlAddress = URLEncoder.encode(urlAddress, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		params.put("address", urlAddress);
		params.put("key", "QC7BZ-RE6LR-LZIWO-WVA75-FGTW2-KZFIQ");
		
		//调用腾讯地图API
		String result = httpClientUtil.doGet(url, params);
		Coordinate coordinate = parseJson.ParseFromTecent(address, result);
		return coordinate;
	}
}
