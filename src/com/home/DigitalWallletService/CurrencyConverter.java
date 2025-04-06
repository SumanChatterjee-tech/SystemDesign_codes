package com.home.DigitalWallletService;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

public class CurrencyConverter {

	  private static final Map<Currency, BigDecimal> exchangeRates = new HashMap<>();

	    static {
	        // Initialize exchange rates
	        exchangeRates.put(Currency.INR, BigDecimal.ONE);
	        exchangeRates.put(Currency.EUR, new BigDecimal("0.85"));
	        exchangeRates.put(Currency.USD, new BigDecimal("0.72"));
	        // Add more exchange rates as needed
	    }

	    public static BigDecimal convert(BigDecimal amount, Currency sourceCurrency, Currency targetCurrency) {
	        BigDecimal sourceRate = exchangeRates.get(sourceCurrency);
	        BigDecimal targetRate = exchangeRates.get(targetCurrency);
	        return amount.multiply(sourceRate).divide(targetRate, RoundingMode.HALF_UP);
	    }
}
