package com.home.RateLimiterDesign;

public class SingletonRateLimiterManager {
	
	private static SingletonRateLimiterManager instance= null;
	private RateLimiter rateLimiter;
	private int maxRequest;
	private long windowSizeMillis;
	private String type;
	
	private SingletonRateLimiterManager(int maxRequest, long windowSizeMillis, String type) {
		this.rateLimiter = RateLimiterFactory.crateRateLimiter(type, maxRequest, windowSizeMillis);
	}
	
	public static SingletonRateLimiterManager getInstance(int maxRequest, long windowSizeMillis, String type) {
        if (instance == null) {
            synchronized (SingletonRateLimiterManager.class) {
                if (instance == null) {
                    instance = new SingletonRateLimiterManager(maxRequest, windowSizeMillis, type);
                }
            }
        }
        return instance;
    }
	
	public boolean allowRequest(String clientId) {
		return this.rateLimiter.allowRequest(clientId);
	}
}
