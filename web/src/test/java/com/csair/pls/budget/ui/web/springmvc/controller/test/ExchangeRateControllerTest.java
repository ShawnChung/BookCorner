/*package com.csair.pls.budget.ui.web.springmvc.controller.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.web.servlet.MockMvc;

import com.csair.pls.budget.domain.ExchangeRate;
import com.csair.pls.budget.service.ExchangeRateService;
import com.csair.pls.budget.ui.web.springmvc.controller.ExchangeRateController;

public class ExchangeRateControllerTest {
  private static final Logger logger = LoggerFactory.getLogger(ExchangeRateControllerTest.class);

  @Test
  public void testShowPage() {
    ExchangeRateController controller = new ExchangeRateController();
    MockMvc mockMvc =
        standaloneSetup(controller).build();
    try {
      mockMvc.perform(get("/ExchangeRate/ShowPage")).andExpect(view().name("ExchangeRate/ShowPage"));
    } catch (Exception e) {
      //logger.error(e.getMessage());
    }
  }
  
  @Test
  public void testGetExchangeRateList() {
    List<ExchangeRate> expectedList = createExpectedList();
    ExchangeRateService mockExchangeRateService = mock(ExchangeRateService.class);
  }

  private List<ExchangeRate> createExpectedList() {
    List<ExchangeRate> exchangeRateList = new ArrayList<ExchangeRate>();
    for(int i = 0; i < 20; i++) {
      ExchangeRate exchangeRate = new ExchangeRate(i, "USD", "美元", 1995 + i, 6.1 + Math.random());
      exchangeRateList.add(exchangeRate);
    }
    return exchangeRateList;
  }

}
*/