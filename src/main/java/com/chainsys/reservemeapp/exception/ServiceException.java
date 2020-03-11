package com.chainsys.reservemeapp.exception;

public class ServiceException extends Exception {
	private static final long serialVersionUID = 1L;

	public ServiceException(String msg,Exception e) {
		super(msg,e);
	}
	

}
