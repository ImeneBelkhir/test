package com.bnp.provider.rest;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bnp.business.PromotionBusiness;

@RestController
public class PromotionController {

	    static final Logger LOG = LoggerFactory.getLogger(PromotionController.class);
	    
	    PromotionBusiness promotionBusiness;
	    
	    
	    @RequestMapping(value = "/articles", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	    public ResponseEntity<Object> getPrice(@RequestParam(value="appleNb", defaultValue="4") int appleNb,
	    		@RequestParam(value="orangeNb", defaultValue="3") int orangeNb,
	    		@RequestParam(value="watermelonNb", defaultValue="5") int watermelonNb) {
	    	LOG.info("Input parameters ===> {} apples, {} oranges, {} watermelons", appleNb, orangeNb, watermelonNb);
	    	
	    	Double total = promotionBusiness.calculatePrice(appleNb, orangeNb, watermelonNb);
	    	Map<String,Double> map = new HashMap<>();
	    	map.put("price", total);
	    	
	    	 if (total == 0.0) {
	    	        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    	    } else {
	    	        return new ResponseEntity<>(map, HttpStatus.OK);
	    	    }
	    }
	    
	    @Autowired
		public void setPromotionBusiness(PromotionBusiness promotionBusiness) {
			this.promotionBusiness = promotionBusiness;
		}
}
