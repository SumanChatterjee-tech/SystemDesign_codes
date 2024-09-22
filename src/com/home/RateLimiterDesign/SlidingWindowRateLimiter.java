package com.home.RateLimiterDesign;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class SlidingWindowRateLimiter implements RateLimiter{

	private int maxReqeuest;
	private long windowSizeMillis;
	private Map<String, Queue<Long>> requestTimestamp;

	public SlidingWindowRateLimiter(int maxReqeuest, long windowSizeMillis) {
		super();
		this.maxReqeuest = maxReqeuest;
		this.windowSizeMillis = windowSizeMillis;
		this.requestTimestamp = new HashMap<>();
	}

	@Override
	public boolean allowRequest(String clientId) {
		long currentTime = System.currentTimeMillis();
		requestTimestamp.putIfAbsent(clientId, new LinkedList<>());

        Queue<Long> timestamps = requestTimestamp.get(clientId);
        while (!timestamps.isEmpty() && currentTime - timestamps.peek() > windowSizeMillis) {
            timestamps.poll();
        }

        if (timestamps.size() < maxReqeuest) {
            timestamps.add(currentTime);
            return true;
        }
        return false;
	}

}
