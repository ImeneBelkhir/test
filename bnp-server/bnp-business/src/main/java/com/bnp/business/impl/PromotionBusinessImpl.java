package com.bnp.business.impl;

import static com.bnp.business.common.Utils.APPLE_PRICE;
import static com.bnp.business.common.Utils.ORANGE_PRICE;
import static com.bnp.business.common.Utils.WATER_MELON_PRICE;
import static com.bnp.business.common.Utils.round;

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
	
}
