package com.bnp.provider.rest;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.bnp.business.PromotionBusiness;

@RunWith(SpringRunner.class)
@WebMvcTest(PromotionController.class)
@AutoConfigureMockMvc(secure = false)
public class PromotionControllerTests {
	
	@Inject
	private MockMvc mvc;
	
	@MockBean
	private PromotionBusiness promotionBusiness;
	
	@Test
	public void testGetPrice() throws Exception {
		when(promotionBusiness.calculatePrice(4, 3, 5)).thenReturn(5.1);
		mvc.perform(get("/articles?appleNb=4&orangeNb=3&watermelons=5").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
		.andDo(print()).andExpect(status().is2xxSuccessful()).andExpect(jsonPath("price", is(5.1)));
	}


}
