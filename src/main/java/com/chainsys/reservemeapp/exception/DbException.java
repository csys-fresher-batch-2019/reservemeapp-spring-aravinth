package com.chainsys.reservemeapp.exception;

import java.sql.SQLException;

public class DbException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DbException(String msg,Exception e) {
		super(msg);
	}

	public DbException(String insertion, SQLException e) {
		// TODO Auto-generated constructor stub
		super(insertion,e);

	}

}
