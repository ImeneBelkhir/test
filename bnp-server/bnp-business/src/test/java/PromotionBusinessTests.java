import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.bnp.business.PromotionBusiness;
import com.bnp.business.impl.PromotionBusinessImpl;

public class PromotionBusinessTests {
	
	PromotionBusiness PromotionBusiness;
	
	@Before
	public void setUp() {
		PromotionBusiness = new PromotionBusinessImpl();
	}
	
	@Test
	public void testCalculatePrice() {
		Double total = PromotionBusiness.calculatePrice(4, 3, 5);
		assertEquals((Double)5.1, total);
	}

}
