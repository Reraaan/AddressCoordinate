package util;

import com.spreada.utils.chinese.ZHConverter;

public class Preprocess {
	
	/*
	 * @description ȥ���ַ����е�
	 * @param String ԭ�ַ���
	 * @return String ������ַ���
	 */
	public String replaceBlank(String str) {
		
		if(str == null) {
			return null;
		}
		 String dest = str.replaceAll(" ", "");
		 dest = dest.replaceAll("\t", "");
		 return dest;
	}
	
	/*
	 * @description ȫ��ת���
	 * @param String ԭ�ַ���
	 * @return String ������ַ���
	 */
	public String fullToHalf(String str) {
		char c[] = str.toCharArray();
		for(int i = 0; i < c.length; i++) {
			//�ո񵥶�����
			if(c[i] == '\u3000') {
				c[i] = ' ';
			} else if(c[i] > '\uFF00' && c[i] < '\uFF5F'){
				c[i] = (char) (c[i] - 65248);
			}
		}
		return new String(c);
	}
	
	/*
	 * @description ����ת����
	 * @param String ԭ�ַ���
	 * @return String ������ַ���
	 */
	public String SimpleToTraditional(String str) {
		ZHConverter converter = ZHConverter.getInstance(ZHConverter.SIMPLIFIED);
		String dest = converter.convert(str);
		return dest;
	}
}
