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
	 * @description 读取txt文件中的地址到List
	 * @param String 文件路径
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
	 * @description 将地址坐标信息写入CSV文件中
	 * @param String 文件路径
	 * @param List<Coordinate> 坐标信息List
	 * @return 
	 */
	public void coordinateToCsv(String path, List<Coordinate> coordinateList) {
		try {
			File csvFile = new File(path);
			BufferedWriter bw = new BufferedWriter(new FileWriter(csvFile, false));
			bw.write("地址,经度,纬度,平台,坐标系");
			bw.newLine();
			for(Coordinate coordinate:coordinateList) {
				bw.write(coordinate.getAddress().getAddress() + "," + coordinate.getlng() + "," + coordinate.getlat()
				+ "," + coordinate.getPlatform() + ","+ coordinate.getCoordinateSystem());
				bw.newLine();
			}
			System.out.println("文件写入完毕！");
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
