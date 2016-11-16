package com.pateo.udf;

public class LocationBean {

	public static int MAXLNG = 180;
	public static int MINLNG = -180;
	public static int MAXLAT =  90;
	public static int MINLAT = -90;
	
	private double lng ;
	private double lat;
	private String geoHash;
	
	public LocationBean(double lat, double lng) {
		super();
		this.lat = lat;
		this.lng = lng;
	}
	
	public double getLng() {
		return lng;
	}
	public void setLng(double lng) {
		this.lng = lng;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public void setGeoHash(String geoHash) {
		this.geoHash = geoHash;
	}
	public String getGeoHash() {
		return geoHash;
	}

	@Override
	public String toString() {
		return "LocationBean [lat,lng=" + lat+ "," + lng + ", geoHash="
				+ geoHash + "]";
	}
	
}
