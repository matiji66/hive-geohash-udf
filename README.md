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
 * 
 * #该方法创建永久的udf函数
 * create function  get_geo as 'com.pateo.udf.GetGeohash' USING JAR 'hdfs:///script/java/udf/GetGeohash.jar'
 * # 删除永久的函数
 * DROP FUNCTION [IF EXISTS] function_name;
