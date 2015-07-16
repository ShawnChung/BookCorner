package com.csair.pls.budget.domain.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.csair.pls.budget.domain.ExchangeRate;

public class ExchangeRateTest {
	static final String USD = "USD";
	static final String JPY = "JPY";
	static final String USD_CHINESE_NAME = "美元";
	static final String JPY_CHINESE_NAME = "日元";
	
	@Test
	public void testCreate() {
		ExchangeRate exchangeRate = new ExchangeRate(USD, USD_CHINESE_NAME, 2015, 6.1);
		assertEquals(USD, exchangeRate.getCurrency());
		assertEquals(USD_CHINESE_NAME, exchangeRate.getCurrencyChineseName());
		assertEquals(2015, exchangeRate.getBudgetYear());
		assertTrue(6.1 == exchangeRate.getValue());
	}

	@Test
	public void testEquals() {
		ExchangeRate exchangeRate = new ExchangeRate(USD, USD_CHINESE_NAME, 2015, 6.1);
		ExchangeRate equalExchangeRate = new ExchangeRate(USD, USD_CHINESE_NAME, 2015, 6.1);
		assertTrue(exchangeRate.equals(equalExchangeRate));
		
		ExchangeRate sameCurrencyDifYearSameValue = new ExchangeRate(USD, USD_CHINESE_NAME, 2014, 6.1);
		assertTrue(exchangeRate.equals(sameCurrencyDifYearSameValue));
		
		ExchangeRate sameCurrencySameYearDifValue = new ExchangeRate(USD, USD_CHINESE_NAME, 2015, 6.2);
		assertFalse(exchangeRate.equals(sameCurrencySameYearDifValue));
		
		ExchangeRate otherCurrency = new ExchangeRate(JPY, JPY_CHINESE_NAME, 2015, 6.1);
		assertFalse(exchangeRate.equals(otherCurrency));
	}

	@Test
	public void testToString() {
		ExchangeRate USDExchangeRate = new ExchangeRate(USD, USD_CHINESE_NAME, 2015, 6.1);
		assertEquals("USD 2015 6.1", USDExchangeRate.toString());
		
		ExchangeRate JPYExchangeRate = new ExchangeRate(JPY, JPY_CHINESE_NAME, 2015, 0.6);
		assertEquals("JPY 2015 0.6", JPYExchangeRate.toString());
	}

}
