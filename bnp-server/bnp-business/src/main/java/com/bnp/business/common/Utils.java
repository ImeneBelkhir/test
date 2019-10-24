package com.bnp.business.common;

public final class Utils {
	public static final double APPLE_PRICE = 0.2;
	public static final double ORANGE_PRICE = 0.5;
	public static final  double WATER_MELON_PRICE = 0.8;
	
	
	private Utils() {
		super();
	}
	
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    long factor = (long) Math.pow(10, places);
	    double val = value * factor;
	    long tmp = Math.round(val);
	    return (double) tmp / factor;
	}
	
	
}
