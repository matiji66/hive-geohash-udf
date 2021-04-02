package com.pateo.udf;

import org.apache.hadoop.hive.ql.exec.UDF;
import com.pateo.udf.GeoHash;

// hive UDF 使用说明传递经纬度,经纬度之间以'|'分割 然后返回经纬度的hash值
// create function get_geo as 'com.pateo.udf.GetGeohash' USING JAR 'hdfs:///script/java/udf/GetGeohash.jar'
public class GetGeohash extends UDF {

	public String evaluate(String latitude, String longitude) {

		String[] split = startAndEnd.split("\\|");
		try {
			return GeoHash.getGeoHash(latitude, longitude, 4);
		} catch (Exception e) {
			e.printStackTrace();
			return "";

		}

	}
}
