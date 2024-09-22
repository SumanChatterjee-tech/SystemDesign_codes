package com.home.RateLimiterDesign;

public class RateLimiterFactory {

	public static RateLimiter crateRateLimiter(String type, int maxRequest, long windowSizeMillis) {
		switch(type.toLowerCase()) {
			case "fixed":
				return new FixedWindowRateLimiter(maxRequest, windowSizeMillis);
			case "sliding":
				return new SlidingWindowRateLimiter(maxRequest, windowSizeMillis);
			default:
				throw new IllegalArgumentException("No proper rate limiter passes");
		}
	}
}
