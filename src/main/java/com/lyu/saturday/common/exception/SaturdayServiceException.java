package com.lyu.saturday.common.exception;


public class SaturdayServiceException extends RuntimeException {
	private String errorMsg;

	public SaturdayServiceException(){
		this.errorMsg = "optional error";
	}

	public SaturdayServiceException(String errorMsg) {
		super(errorMsg);
		this.errorMsg = errorMsg;
	}
}
