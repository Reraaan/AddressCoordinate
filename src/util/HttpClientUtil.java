package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.Map.Entry;

public class HttpClientUtil {
	
	/*
	 * @description 发送get请求
	 * @param String 请求url
	 * @param Map 请求参数
	 * @return 返回结果
	 */
	public String doGet(String url, Map<String, String> params) {
		
		String totalUrl = getUrl(url, params);
		StringBuilder result = new StringBuilder();
		
		try {
			//创建URL对象
			URL urlConn = new URL(totalUrl);
			//打开URL链接
			HttpURLConnection httpConn = (HttpURLConnection) urlConn.openConnection();
			//建立链接
			httpConn.connect();
			
			//获取URLConnection对象对应的输入流
            InputStream is = httpConn.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			//读取返回结果
			String line = null;
            while ((line = br.readLine()) != null) {
                result.append(line);
            }
            
            //关闭流
            is.close();
            //断开连接
            httpConn.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result.toString();
	}
	
	/*
	 * @description 将请求参数拼接到url中
	 * @param String 请求url
	 * @param Map 请求参数
	 * @return String 拼接后的url
	 */
	public String getUrl(String url, Map<String, String> params) {
		
		if(params == null || params.keySet().size() == 0) {
			return url;
		}
		
		//将参数Map转换成String
		StringBuilder paramsString = new StringBuilder();
		for (Entry<String, String> entry : params.entrySet()) {
			paramsString.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
		}
		String urlParams = paramsString.substring(0, paramsString.length() - 1).toString();
		
		url += '?' + urlParams;
		return url;
	}
}
