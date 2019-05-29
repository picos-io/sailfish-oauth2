package io.picos.oauth2.domain.request.impl;


import io.picos.oauth2.domain.request.PageQueryRequest;

/**
 * 分页查询参数实现
 */
public class PageQueryParameter implements PageQueryRequest {

	int start = 0;

	int limit = 20;

	public PageQueryParameter() {
	}

	public PageQueryParameter(int start, int limit) {
		setStart(start);
		setLimit(limit);
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		if (start < 0) {
			start = 0;
		}
		this.start = start;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		if (limit <= 0) {
			limit = 20;
		}
		if (limit > 100) {
			limit = 100;
		}
		this.limit = limit;
	}
}