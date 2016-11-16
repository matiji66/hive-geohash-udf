package com.pateo.udf;

import org.apache.hadoop.hive.ql.exec.UDF;

import com.pateo.udf.GeoHash;

//com.pateo.udf.GetGeohash
// create function get_geo as 'com.pateo.udf.GetGeohash' USING JAR 'hdfs:///script/java/udf/GetGeohash.jar'
/**
 * hive UDF 使用说明传递经纬度,经纬度成对出现，返回的GeoHash值以'|'分隔
 * 
 * latitude1 longitude1 latitude2 longitude2 
 * 
 * hive 中使用
 * # 这个是专门为某个接口用的
 * add jar /var/lib/hadoop-hdfs/GetGeohash.jar;
 * create temporary function getgeohash as 'com.pateo.udf.GetGeohash';
 * #这个通用性比较强 ，能够处理多个经纬度对 ，返回的结果以'|'分隔
 * add jar /var/lib/hadoop-hdfs/GetGeohash.jar;
 * create temporary function getgeohashs as 'com.pateo.udf.GetMultiGeohash';
 * create function  get_geo as 'com.pateo.udf.GetGeohash' USING JAR 'hdfs:///script/java/udf/GetGeohash.jar'
 * 
 * @author sh04595
 */
public class GetMultiGeohash extends UDF {

	public String evaluate(String[] startAndEnd) {

		Integer length = startAndEnd.length;
		if (length % 2 == 1) {
			length -= 1;
		}
		StringBuilder sb = new StringBuilder("");
		for (int i = 0; i < length; i++) {
			String lat = startAndEnd[i];
			String lng = startAndEnd[i + 1];
			i++;
			try {
				sb.append(GeoHash.getGeoHash(lat, lng, 8));
				sb.append("|");

			} catch (Exception e) {
				e.printStackTrace();
				sb.append(" |");
			}
		}

		return  sb.substring(0, sb.length() - 1);
	}

	// public static void main(String[] args) {
	// String s1 = "||";
	// System.out.println("-------" + s1.substring(0, s1.length() - 1));
	// System.out.println("-------" + s1.split("\\|").length);
	// }
}
