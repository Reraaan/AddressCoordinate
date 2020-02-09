package sevice;

import entity.Coordinate;

public class CoordinateSystemTransform {
	
	//圆周率π
	public static double pi = 3.1415926535897932384626;
	
	/*
	 * @description 将BD-09坐标转成GCJ-02坐标
	 * @param Coordinate BD-09坐标
	 * @return Coordinate GCJ-02坐标
	 */
	public Coordinate bd09ToGcj02(Coordinate bd) {
		
	    double x = bd.getlng() - 0.0065;
	    double y = bd.getlat() - 0.006;
	    double z = Math.sqrt(x * x + y * y) - 0.00002 * Math.sin(y * pi);
	    double theta = Math.atan2(y, x) - 0.000003 * Math.cos(x * pi);
	    double gg_lng = z * Math.cos(theta);
	    double gg_lat = z * Math.sin(theta);
	    
	    Coordinate coordinate = new Coordinate();
	    coordinate.setAddress(bd.getAddress());
	    coordinate.setlng(gg_lng);
	    coordinate.setLat(gg_lat);
	    coordinate.setCoordinateSystem("GCJ-02");
	    coordinate.setPlatForm(bd.getPlatform());
	    
	    return coordinate;
	}
	
	/*
	 * @description 将GCJ-02坐标转成BD-09坐标
	 * @param Coordinate GCJ-02坐标
	 * @return Coordinate BD-09坐标
	 */
	public Coordinate gcj02ToBD09(Coordinate gg) {
		
        double x = gg.getlng();
        double y = gg.getlat();
        double z = Math.sqrt(x * x + y * y) + 0.00002 * Math.sin(y * pi);
        double theta = Math.atan2(y, x) + 0.000003 * Math.cos(x * pi);
        double bd_lng = z * Math.cos(theta) + 0.0065;
        double bd_lat = z * Math.sin(theta) + 0.006;
        
        Coordinate coordinate = new Coordinate();
        coordinate.setAddress(gg.getAddress());
        coordinate.setlng(bd_lng);
        coordinate.setLat(bd_lat);
        coordinate.setCoordinateSystem("BD-09");
        coordinate.setPlatForm(gg.getPlatform());
        
        return coordinate;
	}
}
