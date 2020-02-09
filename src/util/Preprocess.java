package util;

import com.spreada.utils.chinese.ZHConverter;

public class Preprocess {
	
	/*
	 * @description 去除字符串中的
	 * @param String 原字符串
	 * @return String 处理后字符串
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
	 * @description 全角转半角
	 * @param String 原字符串
	 * @return String 处理后字符串
	 */
	public String fullToHalf(String str) {
		char c[] = str.toCharArray();
		for(int i = 0; i < c.length; i++) {
			//空格单独处理
			if(c[i] == '\u3000') {
				c[i] = ' ';
			} else if(c[i] > '\uFF00' && c[i] < '\uFF5F'){
				c[i] = (char) (c[i] - 65248);
			}
		}
		return new String(c);
	}
	
	/*
	 * @description 繁体转简体
	 * @param String 原字符串
	 * @return String 处理后字符串
	 */
	public String SimpleToTraditional(String str) {
		ZHConverter converter = ZHConverter.getInstance(ZHConverter.SIMPLIFIED);
		String dest = converter.convert(str);
		return dest;
	}
}
