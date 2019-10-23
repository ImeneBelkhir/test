package com.bnp.business.impl;

import static com.bnp.business.utils.Contstants.APPLE_PRICE;
import static com.bnp.business.utils.Contstants.ORANGE_PRICE;
import static com.bnp.business.utils.Contstants.WATER_MELON_PRICE;

import org.springframework.stereotype.Service;

import com.bnp.business.PromotionBusiness;
@Service
public class PromotionBusinessImpl implements PromotionBusiness {

	@Override
	public double calculatePrice(int appleNb, int orangeNb, int waterMelonNb) {
		double total;
		
		total = ((appleNb / 2 ) * APPLE_PRICE) + (appleNb % 2 * APPLE_PRICE);
		total += orangeNb * ORANGE_PRICE;
		total += ((waterMelonNb / 3 ) * WATER_MELON_PRICE * 2) + (waterMelonNb % 3 * WATER_MELON_PRICE);
		
		return round(total, 2);
	}
	
	public static double round(double value, int places) {
	    if (places < 0) throw new IllegalArgumentException();

	    long factor = (long) Math.pow(10, places);
	    double val = value * factor;
	    long tmp = Math.round(val);
	    return (double) tmp / factor;
	}

}
