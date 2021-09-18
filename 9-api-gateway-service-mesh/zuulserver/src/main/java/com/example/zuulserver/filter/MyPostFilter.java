package com.example.zuulserver.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.netflix.zuul.exception.ZuulException;

@Component
public class MyPostFilter {

	private static final int FILTER_ORDER = 1;
	private static final boolean SHOULD_FILTER = true;
	public static String POST_FILTER_TYPE;
	private static final Logger LOGGER = LoggerFactory.getLogger(MyPostFilter.class);

	@Autowired
	private FilterUtils filterUtils;

	public boolean shouldFilter() {
		return SHOULD_FILTER;
	}

	public Object run() throws ZuulException {
		return null;
	}

	public String filterType() {
		return POST_FILTER_TYPE;
	}

	public int filterOrder() {
		return FILTER_ORDER;
	}
}
