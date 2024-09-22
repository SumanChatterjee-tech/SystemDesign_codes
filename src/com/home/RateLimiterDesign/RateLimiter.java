package com.home.RateLimiterDesign;

public interface RateLimiter {
	boolean allowRequest(String clientId);
}
