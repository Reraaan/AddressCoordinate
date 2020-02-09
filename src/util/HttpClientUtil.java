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
	 * @description ����get����
	 * @param String ����url
	 * @param Map �������
	 * @return ���ؽ��
	 */
	public String doGet(String url, Map<String, String> params) {
		
		String totalUrl = getUrl(url, params);
		StringBuilder result = new StringBuilder();
		
		try {
			//����URL����
			URL urlConn = new URL(totalUrl);
			//��URL����
			HttpURLConnection httpConn = (HttpURLConnection) urlConn.openConnection();
			//��������
			httpConn.connect();
			
			//��ȡURLConnection�����Ӧ��������
            InputStream is = httpConn.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			//��ȡ���ؽ��
			String line = null;
            while ((line = br.readLine()) != null) {
                result.append(line);
            }
            
            //�ر���
            is.close();
            //�Ͽ�����
            httpConn.disconnect();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result.toString();
	}
	
	/*
	 * @description ���������ƴ�ӵ�url��
	 * @param String ����url
	 * @param Map �������
	 * @return String ƴ�Ӻ��url
	 */
	public String getUrl(String url, Map<String, String> params) {
		
		if(params == null || params.keySet().size() == 0) {
			return url;
		}
		
		//������Mapת����String
		StringBuilder paramsString = new StringBuilder();
		for (Entry<String, String> entry : params.entrySet()) {
			paramsString.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
		}
		String urlParams = paramsString.substring(0, paramsString.length() - 1).toString();
		
		url += '?' + urlParams;
		return url;
	}
}
