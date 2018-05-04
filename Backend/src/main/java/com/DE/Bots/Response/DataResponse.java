package com.DE.Bots.Response;

public class DataResponse<T> {
	private final T result;
	private final long latsUpdated;

	public DataResponse(T result, long lastUpdated) {
		this.result = result;
		this.latsUpdated = lastUpdated;
	}

	public T getResult() {
		return result;
	}

	public long getLatsUpdated() {
		return latsUpdated;
	}

}
