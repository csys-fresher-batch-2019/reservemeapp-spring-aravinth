package com.chainsys.reservemeapp.exception;

public class DbException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DbException(String msg,Exception e) {
		super(msg,e);
	}

	

}
