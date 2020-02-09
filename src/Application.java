import java.util.ArrayList;
import java.util.List;

import entity.Address;
import entity.Coordinate;
import sevice.CoordinateSystemTransform;
import sevice.GetCoordinate;
import util.FileUtil;
import util.Preprocess;

public class Application {
	
	public static void main(String[] args) {
//		Address address = new Address();
//		address.setAddress("东莞市石碣镇新城区A4062/SZ063");
//		GetCoordinate co = new GetCoordinate();
//		System.out.println(co.getByBaidu(address).getlat());
//		System.out.println(co.getByGaode(address).getlat());
//		System.out.println(co.getByTecent(address).getlat());
		
		FileUtil fileUtil = new FileUtil();
		GetCoordinate getCoordinate = new GetCoordinate();
		Preprocess preprocess = new Preprocess();
		CoordinateSystemTransform transform = new CoordinateSystemTransform();
		List<Coordinate> coordinateList = new ArrayList<Coordinate>();
		List<String> addressList = fileUtil.txtToList("D:\\holmesbi\\address.txt");
		for(String addr:addressList) {
			Address address = new Address();
			addr = preprocess.fullToHalf(addr);
			addr = preprocess.replaceBlank(addr);
			System.out.println(addr);
			address.setAddress(addr);
			Coordinate baidu = getCoordinate.getByBaidu(address);
			Coordinate gaode = getCoordinate.getByGaode(address);
			Coordinate tecent = getCoordinate.getByTecent(address);
			if(baidu != null) {
				coordinateList.add(baidu);
				coordinateList.add(transform.bd09ToGcj02(baidu));
			}
			if(gaode != null) {
				coordinateList.add(gaode);
			}
			if(tecent != null) {
				coordinateList.add(tecent);
			}
		}
		fileUtil.coordinateToCsv("D:\\holmesbi\\coordinate.csv", coordinateList);
	}
}
