package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import entity.Coordinate;

public class FileUtil {
	
	/*
	 * @description ��ȡtxt�ļ��еĵ�ַ��List
	 * @param String �ļ�·��
	 * @return List
	 */
	public List<String> txtToList(String path) {
		List<String> addressList = new ArrayList<String>();
		try {
			FileInputStream file = new FileInputStream(path);
			BufferedReader br = new BufferedReader(new InputStreamReader(file, "UTF-8"));
			String line = null;
            while((line = br.readLine()) != null ) {
                addressList.add(line);
            }
            br.close();  
		} catch (Exception e) {
			e.printStackTrace();
		}
		return addressList;
	}
	
	/*
	 * @description ����ַ������Ϣд��CSV�ļ���
	 * @param String �ļ�·��
	 * @param List<Coordinate> ������ϢList
	 * @return 
	 */
	public void coordinateToCsv(String path, List<Coordinate> coordinateList) {
		try {
			File csvFile = new File(path);
			BufferedWriter bw = new BufferedWriter(new FileWriter(csvFile, false));
			bw.write("��ַ,����,γ��,ƽ̨,����ϵ");
			bw.newLine();
			for(Coordinate coordinate:coordinateList) {
				bw.write(coordinate.getAddress().getAddress() + "," + coordinate.getlng() + "," + coordinate.getlat()
				+ "," + coordinate.getPlatform() + ","+ coordinate.getCoordinateSystem());
				bw.newLine();
			}
			System.out.println("�ļ�д����ϣ�");
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
