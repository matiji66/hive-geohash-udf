package com.pateo.udf;

import org.apache.hadoop.hive.ql.exec.UDF;
import com.pateo.udf.GeoHash;

// hive UDF 使用说明传递经纬度,经纬度之间以'|'分割 然后返回经纬度的hash值
// create function get_geo as 'com.pateo.udf.GetGeohash' USING JAR 'hdfs:///script/java/udf/GetGeohash.jar'
public class GetGeohash extends UDF {

	public String evaluate(String startAndEnd) {

		String[] split = startAndEnd.split("\\|");
		try {
			if (split.length == 4) {
				String s_lat = split[0];
				String s_lng = split[1];
				String e_lat = split[2];
				String e_lng = split[3];
 				return GeoHash.getGeoHash(s_lat, s_lng, 5) + "|"
						+ GeoHash.getGeoHash(e_lat, e_lng, 7);
			} else {
				return "";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "";

		}

	}
//	public static void main(String[] args) {
//		String s1 = " | ";
//		System.out.println("-------" + s1.split("\\|").length +"+++");
//	}
}
