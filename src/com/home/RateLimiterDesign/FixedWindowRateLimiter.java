package com.home.RateLimiterDesign;

import java.util.HashMap;
import java.util.Map;

public class FixedWindowRateLimiter implements RateLimiter{

	private int maxReqst;
	private long windowSizeMillis;
	private Map<String, Integer> reqstCounts;
	private Map<String, Long> windowStartTimes;
	
	
	public FixedWindowRateLimiter(int maxReqst, long windowSizeMillis) {
		super();
		this.maxReqst = maxReqst;
		this.windowSizeMillis = windowSizeMillis;
		this.reqstCounts = new HashMap<>();
		this.windowStartTimes = new HashMap<>();
	}


	@Override
	public boolean allowRequest(String clientId) {
		long currTime = System.currentTimeMillis();
		windowStartTimes.putIfAbsent(clientId, currTime);
		reqstCounts.putIfAbsent(clientId, 0);
		
		long windowStartTime = windowStartTimes.get(clientId);
		
		if(currTime - windowStartTime >= windowSizeMillis) { //client exceed the time frame, hence start new counter
			windowStartTimes.put(clientId, currTime);
			reqstCounts.put(clientId, 0);
		}
		
		int requestCount = reqstCounts.get(clientId);
		
		if(requestCount< maxReqst) {
			reqstCounts.put(clientId, requestCount+1);
			return true;
		}
		
		return false;
	}

}
